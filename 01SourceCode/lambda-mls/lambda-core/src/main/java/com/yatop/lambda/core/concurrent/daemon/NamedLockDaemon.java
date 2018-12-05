package com.yatop.lambda.core.concurrent.daemon;

import com.yatop.lambda.core.concurrent.lock.NamedLock.LockRequest;
import com.yatop.lambda.core.utils.DataUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class NamedLockDaemon implements DisposableBean, Runnable {
    //负责完成串行加锁
    private Thread thread;
    private ConcurrentLinkedQueue<LockRequest> queue;
    private volatile boolean exit;

    NamedLockDaemon(){
        this.exit = false;
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run(){
        while(!exit){
            try {
                this.wait(8 * 1000);
                dealRequest();
            }catch (Throwable e) {
                continue;
            }
        }
        cleanRequest();
    }

    @Override
    public void destroy(){
        this.exit = true;
        this.thread.interrupt();
    }

    private void dealRequest() {
        while(!queue.isEmpty()) {
            LockRequest lockRequest = queue.poll();
            if(DataUtil.isNotNull(lockRequest)) {
                lockRequest.lock();
                lockRequest.notify();
            }
        }
    }

    private void cleanRequest() {
        while (!queue.isEmpty()) {
            LockRequest lockRequest = queue.poll();
            if(DataUtil.isNotNull(lockRequest)) {
                lockRequest.notify();
            }
        }
    }

    public void requestLock(LockRequest lockRequest) {
        try {
            this.queue.offer(lockRequest);
            this.notify();
            lockRequest.wait(8 * 1000);
        } catch (Throwable e) {
        }
    }
}