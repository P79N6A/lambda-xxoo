package com.yatop.lambda.core.concurrent.lock;

import com.yatop.lambda.core.concurrent.daemon.NamedLockDaemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowNamedLock extends NamedLock implements INamedLock {

    @Autowired
    NamedLockDaemon namedLockDaemon;

    public WorkflowNamedLock() {
        super();
    }

    @Override
    public boolean requestResource(Long id) {
        LockRequest request = new LockRequest(this, id, Thread.currentThread());
        namedLockDaemon.requestLock(request);
        return request.isHold();
    }

    @Override
    public void releaseResource(Long id) {
        doUnlock();
    }
}
