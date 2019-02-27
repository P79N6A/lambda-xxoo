package com.yatop.lambda.manager.common.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author wuzq
 * @date 2018/10/15.
 */
public class Swagger2Condition implements Condition {

    public static final String SWAGGER_CONFIG_NAME = "swagger2.enable";

    public static final String SWAGGER_ENABLE = "1";
    public static final String SWAGGER_UNABLE = "0";


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return true;
    }
}
