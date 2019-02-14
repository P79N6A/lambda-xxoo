package com.yatop.lambda.portal.common.function;

import com.yatop.lambda.portal.common.exception.RedisConnectException;

@FunctionalInterface
public interface JedisExecutor<T, R> {
    R excute(T t) throws RedisConnectException;
}
