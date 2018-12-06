package com.yatop.lambda.core.concurrent.daemon;

import com.yatop.lambda.core.concurrent.lock.NamedLock;
import com.yatop.lambda.core.concurrent.lock.NamedLock.LockRequest;
import com.yatop.lambda.core.utils.DataUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class NamedLockDaemon implements DisposableBean, Runnable {
    //负责完成串行加锁和过期锁清理
    private Thread thread;
    private ConcurrentLinkedQueue<LockRequest> lockQueue;
    private ConcurrentLinkedQueue<LockRequest> unlockQueue;
    private TreeMap<String, NamedLock> registedNamedLockMap = new TreeMap<String, NamedLock>();
    private long counter;
    private volatile boolean exit;

    NamedLockDaemon(){
        this.exit = false;
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run(){
        this.counter = 0;
        while(!exit){
            try {
                this.wait(8 * 1000);
                dealQueueRequest();
            }catch (Throwable e) {
                continue;
            }
        }
        clearQueueRequest();
    }

    @Override
    public void destroy(){
        this.exit = true;
        this.thread.interrupt();
    }

    private void dealQueueRequest() {

        while(!this.unlockQueue.isEmpty()) {
            LockRequest unlockRequest = this.unlockQueue.poll();
            if(DataUtil.isNotNull(unlockRequest)) {
                unlockRequest.unlock();
            }
        }

        while(!this.lockQueue.isEmpty()) {
            ++this.counter;

            while(!this.unlockQueue.isEmpty()) {
                LockRequest unlockRequest = this.unlockQueue.poll();
                if(DataUtil.isNotNull(unlockRequest)) {
                    unlockRequest.unlock();
                }
            }

            LockRequest lockRequest = this.lockQueue.poll();
            if(DataUtil.isNotNull(lockRequest)) {
                registerNamedLock(lockRequest);
                lockRequest.lock();
                lockRequest.notify();
            }
            clearExpireLock();
        }
        clearExpireLock();
    }

    private void registerNamedLock(LockRequest lockRequest) {
        if(DataUtil.isNull(this.registedNamedLockMap.get(lockRequest.namedLockId())))
            this.registedNamedLockMap.put(lockRequest.namedLockId(), lockRequest.getNamedLock());
    }

    private void clearQueueRequest() {
        while (!this.lockQueue.isEmpty()) {
            LockRequest lockRequest = this.lockQueue.poll();
            if (DataUtil.isNotNull(lockRequest)) {
                lockRequest.notify();
            }
        }
        this.unlockQueue.clear();
    }

    private void clearExpireLock() {
        if(this.counter > 997) {
            if(!this.registedNamedLockMap.isEmpty()) {
                Iterator<Map.Entry<String, NamedLock>> iterator = this.registedNamedLockMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, NamedLock> entry = iterator.next();
                    entry.getValue().clearExpireLock();
                }
            }
            this.counter = 0;
        }
    }

    public LockRequest requestLock(LockRequest lockRequest) {
        if(DataUtil.isNotNull(lockRequest)) {
            if (lockRequest.isIdle()) {
                try {
                    this.lockQueue.offer(lockRequest);
                    this.notify();
                    lockRequest.wait(8 * 1000);
                } catch (Throwable e) {
                }
            }
        }
        return lockRequest;
    }

    public LockRequest requestUnlock(LockRequest unlockRequest) {
        if(DataUtil.isNotNull(unlockRequest)) {
            this.unlockQueue.offer(unlockRequest);
            this.notify();
        }
        return unlockRequest;
    }
}