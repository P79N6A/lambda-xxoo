package com.yatop.lambda.core.concurrent.lock;

public interface INamedLock {
    boolean requestResource(Long resourceId);
    void releaseResource();
}
