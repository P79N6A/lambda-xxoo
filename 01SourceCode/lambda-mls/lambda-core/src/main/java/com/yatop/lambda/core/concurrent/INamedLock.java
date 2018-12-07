package com.yatop.lambda.core.concurrent;

public interface INamedLock {
    boolean requestResource(Long resourceId);
    void releaseResource();
}
