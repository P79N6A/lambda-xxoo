package com.yatop.lambda.portal.common.function;

@FunctionalInterface
public interface CacheSelector<T> {
    T select() throws Exception;
}
