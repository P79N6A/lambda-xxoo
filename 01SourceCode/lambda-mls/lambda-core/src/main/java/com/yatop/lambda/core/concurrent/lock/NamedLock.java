package com.yatop.lambda.core.concurrent.lock;

import com.yatop.lambda.core.utils.DataUtil;
import org.springframework.beans.factory.DisposableBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class NamedLock implements DisposableBean, Runnable {
    //负责完成清理过期线程加锁
    protected Thread thread;
    protected volatile boolean exit;

    //加锁资源ID, 加锁请求
    private ConcurrentHashMap<Long, LockRequest> namedLockHashMap = new ConcurrentHashMap<Long, LockRequest>();

    //加锁线程ID，加锁请求链表
    private ConcurrentHashMap<Long, ConcurrentLinkedQueue<LockRequest>> threadChainHashMap = new ConcurrentHashMap<Long, ConcurrentLinkedQueue<LockRequest>>();

    //定期过期检测中未过期加锁请求缓存，过期时间，加锁请求链表
    private TreeMap<Long, ArrayList<LockRequest>> clearExpireCacheMap = new TreeMap<Long, ArrayList<LockRequest>>();

    NamedLock() {
        this.exit = false;
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run(){
        while(!exit){
            try {
                this.wait(8 * 1000);
                doClearExpire();
            }catch (Throwable e) {
                continue;
            }
        }
    }

    @Override
    public void destroy(){
        this.exit = true;
        this.thread.interrupt();
    }

    private void lock(LockRequest request) {
        LockRequest holdRequest = namedLockHashMap.get(request.getName());
        if(DataUtil.isNull(holdRequest) || holdRequest.isNotHold()) {
            namedLockHashMap.put(request.getName(),request);
            request.setHold(true);
            ConcurrentLinkedQueue<LockRequest> requestList = threadChainHashMap.get(request.getThread().getId());
            if(DataUtil.isNull(requestList)) {
                ConcurrentLinkedQueue<LockRequest> chainList = new ConcurrentLinkedQueue<LockRequest>();
                chainList.offer(request);
                threadChainHashMap.put(request.getThread().getId(), chainList);
            } else {
                requestList.offer(request);
            }
        }
    }

    //解锁清理当前线程该类资源的所有占有
    private void unlock() {
        ConcurrentLinkedQueue<LockRequest> requestList = threadChainHashMap.get(Thread.currentThread().getId());
        if(DataUtil.isNotNull(requestList)) {
            requestList = threadChainHashMap.remove(Thread.currentThread().getId());

            for(LockRequest request : requestList) {
                namedLockHashMap.remove(request.getName());
                request.setHold(false);
            }
            requestList.clear();
        }
    }

    protected void doUnlock() {
        unlock();
    }

    //定期过期检测防止内存泄漏
    protected void doClearExpire() {
        {
            Iterator<Map.Entry<Long, ArrayList<LockRequest>>> iterator = clearExpireCacheMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Long, ArrayList<LockRequest>> entry = iterator.next();
                if(entry.getKey() <= System.currentTimeMillis()) {
                    for(LockRequest cacheRequest : entry.getValue() ) {
                        cacheRequest.setHold(false);
                        namedLockHashMap.remove(cacheRequest.getName());
                    }
                    iterator.remove();
                } else {
                    break;
                }
            }
        }

        for(Long threadId : threadChainHashMap.keySet()) {

            ConcurrentLinkedQueue<LockRequest> requestList = threadChainHashMap.get(threadId);
            if(DataUtil.isNotNull(requestList)) {
                LockRequest peekLock = requestList.peek();
                if(DataUtil.isNotNull(peekLock) && peekLock.isNotHold()) {

                    requestList = threadChainHashMap.remove(threadId);
                    if(DataUtil.isNotNull(requestList)) {
                        for (LockRequest requestLock : requestList) {
                            if(requestLock.isNotHold()) {
                                requestLock.setHold(false);
                                namedLockHashMap.remove(requestLock.getName());
                            } else {
                                ArrayList<LockRequest> cacheList = clearExpireCacheMap.get(requestLock.getExpire());
                                if(DataUtil.isNull(cacheList))
                                    cacheList.add(requestLock);
                                else {
                                    cacheList = new ArrayList<LockRequest>();
                                    clearExpireCacheMap.put(requestLock.getExpire(), cacheList);

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static class LockRequest {
        private  NamedLock lock;
        private Long name;
        private Thread thread;
        private Long expire;
        private volatile boolean hold;

        public LockRequest(NamedLock lock, Long name, Thread thead) {
            this.lock = lock;
            this.name = name;
            this.thread = thead;
            this.expire = System.currentTimeMillis() + 16 * 1000;
            this.hold = false;
        }

        public void lock() {
            lock.lock(this);
        }

        public Long getName() {
            return name;
        }

        public Thread getThread() {
            return thread;
        }

        public Long getExpire() {
            return expire;
        }

        public boolean isHold() {
            return hold && (System.currentTimeMillis() < this.expire);
        }

        public boolean isNotHold() {
            return !isHold();
        }

        private void setHold(boolean hold) {
            this.hold = hold;
        }
    }
}
