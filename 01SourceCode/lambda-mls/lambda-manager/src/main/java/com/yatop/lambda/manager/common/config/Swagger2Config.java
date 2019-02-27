package com.yatop.lambda.manager.common.config;

import com.google.common.base.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;


/**
 * @author wuzq
 */


public class Swagger2Config {

    /**
     * 定义api组，
     */
    @Bean
    public Docket innerApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authorization").description("token令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("lambda-manager")
//                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .select()
//                .apis(Swagger2Config.basePackage("com.yatop.framework.base.controller"))
                .apis(Swagger2Config.basePackage("com.yatop.lambda"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .apiInfo(innerApiInfo());
    }

    private ApiInfo innerApiInfo() {
        return new ApiInfoBuilder()
                .title("yatop")
                .description("系统接口-api")
                .version("1.0")
                .build();
    }

    /**
     * 指定包的API，并且过滤掉没有使用Api注解的类
     *
     * @param basePackage - base package of the classes
     * @return this
     */
    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                if (declaringClass(input).isAnnotationPresent(Api.class)) {
                    return declaringClass(input).getPackage().getName().startsWith(basePackage)&&input.getHandlerMethod().getMethod().isAnnotationPresent(ApiOperation.class);
                }
                return false;
            }
        };
    }

    private static Class<?> declaringClass(RequestHandler input) {
        return input.getHandlerMethod().getBeanType();
    }
}
