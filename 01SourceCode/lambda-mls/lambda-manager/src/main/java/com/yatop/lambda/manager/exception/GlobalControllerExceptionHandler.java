package com.yatop.lambda.manager.exception;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.manager.api.response.JsonResponse;
import com.yatop.lambda.portal.common.handler.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalControllerExceptionHandler extends GlobalExceptionHandler {

    public static Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler(value = LambdaException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object requestParamErrorHandler(HttpServletRequest req, LambdaException lambdaException) throws Exception {
        logger.info("业务异常错误", lambdaException);
        return JsonResponse.build(lambdaException);
    }
}
