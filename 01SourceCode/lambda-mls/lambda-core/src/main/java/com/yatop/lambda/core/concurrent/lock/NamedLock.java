package com.yatop.lambda.core.concurrent.lock;

import com.yatop.lambda.core.utils.DataUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class NamedLock {

    //加锁资源ID, 加锁请求
    private ConcurrentHashMap<Long, LockRequest> namedLockHashMap = new ConcurrentHashMap<Long, LockRequest>();

    //加锁线程ID，加锁请求链表
    private ConcurrentHashMap<Long, ConcurrentLinkedQueue<LockRequest>> threadChainHashMap = new ConcurrentHashMap<Long, ConcurrentLinkedQueue<LockRequest>>();

    //定期过期检测中未过期加锁请求缓存，过期时间，加锁请求链表
    private TreeMap<Long, ArrayList<LockRequest>> clearExpireCacheMap = new TreeMap<Long, ArrayList<LockRequest>>();

    private boolean isLocked(LockRequest lockRequest) {
        LockRequest holdRequest = namedLockHashMap.get(lockRequest.getName());
        return DataUtil.isNotNull(holdRequest) ? holdRequest.getExpire() < System.currentTimeMillis() : false;
    }

    private void lock(LockRequest requestLock) {
        if(requestLock.getExpire() < System.currentTimeMillis())
            return;

        LockRequest holdRequest = this.namedLockHashMap.get(requestLock.getName());
        //相同线程对同一资源请求，需要前一请求过期后才能再次占有，代码上应当杜绝此类情况出现
        if(DataUtil.isNull(holdRequest) || holdRequest.isNotHold()) {
            this.namedLockHashMap.put(requestLock.getName(), requestLock);
            requestLock.setHold(true);
            ConcurrentLinkedQueue<LockRequest> chainList = this.threadChainHashMap.get(requestLock.getThread().getId());
            if(DataUtil.isNull(chainList)) {
                ConcurrentLinkedQueue<LockRequest> newChainList = new ConcurrentLinkedQueue<LockRequest>();
                newChainList.offer(requestLock);
                this.threadChainHashMap.put(requestLock.getThread().getId(), newChainList);
            } else {
                chainList.offer(requestLock);
            }
        }
    }

    //解锁清理当前线程该类资源的所有占有
    private void unlock(LockRequest requestLock) {
        ConcurrentLinkedQueue<LockRequest> chainList = this.threadChainHashMap.get(requestLock.getThread().getId());
        if(DataUtil.isNotNull(chainList)) {
            chainList = this.threadChainHashMap.remove(Thread.currentThread().getId());

            Long curThreadId = requestLock.getThread().getId();
            for(LockRequest holdRequest : chainList) {
                if(this.namedLockHashMap.get(holdRequest.getName()).getThread().getId() == curThreadId)
                    this.namedLockHashMap.remove(holdRequest.getName());
                holdRequest.setHold(false);
            }
            chainList.clear();
        }
    }

    public LockRequest prepareDoLock(Long resourceId) {
        return new LockRequest(this, resourceId);
    }

    public LockRequest prepareDoUnlock() {
        ConcurrentLinkedQueue<LockRequest> chainList = threadChainHashMap.get(Thread.currentThread().getId());
        return DataUtil.isNotNull(chainList) ? chainList.peek() : null;
    }

    //定期过期检测防止内存泄漏
    public void clearExpireLock() {
        {
            if(!this.clearExpireCacheMap.isEmpty()) {
                Iterator<Map.Entry<Long, ArrayList<LockRequest>>> iterator = this.clearExpireCacheMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Long, ArrayList<LockRequest>> entry = iterator.next();
                    if (entry.getKey() < System.currentTimeMillis()) {
                        for (LockRequest cacheRequest : entry.getValue()) {
                            cacheRequest.setHold(false);
                            if(this.namedLockHashMap.get(cacheRequest.getName()).getThread().getId() == cacheRequest.getThread().getId())
                                this.namedLockHashMap.remove(cacheRequest.getName());
                        }
                        iterator.remove();
                    } else {
                        break;
                    }
                }
            }
        }

        for(Long curThreadId : this.threadChainHashMap.keySet()) {

            ConcurrentLinkedQueue<LockRequest> chainList = this.threadChainHashMap.get(curThreadId);
            if(DataUtil.isNotNull(chainList)) {
                LockRequest peekLock = chainList.peek();
                if(DataUtil.isNotNull(peekLock) && peekLock.isNotHold()) {

                    chainList = this.threadChainHashMap.remove(curThreadId);
                    if(DataUtil.isNotNull(chainList)) {
                        for (LockRequest holdRequest : chainList) {
                            if(holdRequest.isNotHold()) {
                                holdRequest.setHold(false);
                                if(this.namedLockHashMap.get(holdRequest.getName()).getThread().getId() == curThreadId)
                                    this.namedLockHashMap.remove(holdRequest.getName());
                            } else {
                                ArrayList<LockRequest> cacheList = this.clearExpireCacheMap.get(holdRequest.getExpire());
                                if(DataUtil.isNotNull(cacheList))
                                    cacheList.add(holdRequest);
                                else {
                                    cacheList = new ArrayList<LockRequest>();
                                    cacheList.add(holdRequest);
                                    this.clearExpireCacheMap.put(holdRequest.getExpire(), cacheList);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public abstract String namedLockId();

    public static class LockRequest {
        private  NamedLock lock;
        private Long name;
        private Thread thread;
        private Long expire;
        private volatile boolean hold;

        private LockRequest(NamedLock lock, Long name) {
            this.lock = lock;
            this.name = name;
            this.thread = Thread.currentThread();
            this.expire = System.currentTimeMillis() + 16 * 1000;
            this.hold = false;
        }

        public void lock() {
            this.lock.lock(this);
        }

        public void unlock() {
            this.lock.unlock(this);
        }

        public Long getName() {
            return this.name;
        }

        public Thread getThread() {
            return this.thread;
        }

        public Long getExpire() {
            return this.expire;
        }

        public NamedLock getNamedLock() {
            return this.lock;
        }

        public String namedLockId() {
            return this.lock.namedLockId();
        }

        public boolean isIdle() {
            return !this.lock.isLocked(this);
        }

        public boolean isHold() {
            return this.hold && (System.currentTimeMillis() < this.expire);
        }

        public boolean isNotHold() {
            return !isHold();
        }

        private void setHold(boolean hold) {
            this.hold = hold;
        }
    }
}
