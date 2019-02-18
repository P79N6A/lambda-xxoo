package com.yatop.lambda.portal.common.handler;

import com.yatop.lambda.portal.common.domain.PortalResponse;
import com.yatop.lambda.portal.common.exception.PortalException;
import com.yatop.lambda.portal.common.exception.LimitAccessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;
import java.util.Set;

@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public PortalResponse handleException(Exception e) {
        log.error("系统内部错误：", e);
        return new PortalResponse().message("系统内部错误");
    }

    @ExceptionHandler(value = PortalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public PortalResponse handleParamsInvalidException(PortalException e) {
        log.debug("业务请求失败：{}", e);
        return new PortalResponse().message(e.getMessage());
    }

    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return PortalResponse
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public PortalResponse validExceptionHandler(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(";");
        }
        return new PortalResponse().message(message.toString());

    }

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return PortalResponse
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public PortalResponse handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");
            message.append(pathArr[1]).append(violation.getMessage()).append(";");
        }
        return new PortalResponse().message(message.toString());
    }

    @ExceptionHandler(value = LimitAccessException.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public PortalResponse handleLimitAccessException(LimitAccessException e) {
        log.warn(e.getMessage());
        return new PortalResponse().message(e.getMessage());
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public PortalResponse handleUnauthorizedException(UnauthorizedException e) {
        log.debug("无访问权限，{}", e.getMessage());
        return new PortalResponse().message("无访问权限");
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthenticatedException.class)
    public PortalResponse handleUnauthenticatedException(UnauthenticatedException e) {
        log.debug("未认证请求，{}", e.getMessage());
        return new PortalResponse().message("请先登录");
    }
}
