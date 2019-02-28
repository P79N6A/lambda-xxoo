package com.yatop.lambda.manager.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger 模块
 * 访问方式：例如：http://localhost:8082/mp/swagger-ui.html
 *
 * @author YSW
 */

@Configuration
@EnableSwagger2
/**
 * 生产环境不加载swagger2功能
 */
@Conditional(value = Swagger2Condition.class)
public class MpSwagger2ConfigUtils extends Swagger2Config {

    /**
     * 定义api组
     */
    @Bean
    public Docket project() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authentication").description("token令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Manager-Api")
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .select()
                .apis(Swagger2Config.basePackage("com.yatop.lambda.manager.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .apiInfo(dgpApiInfo("算法平台-api"));
    }

    private ApiInfo dgpApiInfo(String content) {
        return new ApiInfoBuilder()
                .title("yatop")
                .description(content)
                .version("1.0")
                .build();
    }
}
