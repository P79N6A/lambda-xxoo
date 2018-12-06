package com.yatop.lambda.core.concurrent.lock;

import com.yatop.lambda.base.model.WfFlow;
import com.yatop.lambda.core.concurrent.daemon.NamedLockDaemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowNamedLock extends NamedLock implements INamedLock {

    @Autowired
    NamedLockDaemon namedLockDaemon;

    @Override
    public String namedLockId() {
        return this.getClass().getName();
    }

    @Override
    public boolean requestResource(Long resourceId) {
        return namedLockDaemon.requestLock(super.prepareDoLock(resourceId)).isHold();
    }

    @Override
    public void releaseResource() {
        namedLockDaemon.requestUnlock(super.prepareDoUnlock());
    }
}
