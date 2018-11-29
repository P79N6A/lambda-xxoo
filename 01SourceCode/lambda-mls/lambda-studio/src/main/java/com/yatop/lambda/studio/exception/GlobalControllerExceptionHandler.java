package com.yatop.lambda.studio.exception;

import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.studio.response.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    public static Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);
/*
    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.OK)
    public @ResponseBody
    HashMap<String, Object> handleInvalidRequestException(LambdaException e) {
        logger.warn(e.getMessage(), e);
        HashMap<String, Object> errorResp = getResponse(HttpStatus.BAD_REQUEST, e);
        return errorResp;
    }

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    HashMap<String, Object> handleInternalServerException(LambdaException e) {
        logger.error(e.getMessage(), e);
        HashMap<String, Object> errorResp = getResponse(HttpStatus.INTERNAL_SERVER_ERROR, e);
        return errorResp;
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public @ResponseBody
    HashMap<String, Object> handleInternalServerException(UnauthorizedAccessException e) {
        logger.warn(e.getMessage(), e);
        HashMap<String, Object> errorResp = getResponse(HttpStatus.UNAUTHORIZED, e);
        return errorResp;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    HashMap<String, Object> handleResourceNotFoundException(LambdaException e) {
        logger.error(e.getMessage(), e);
        HashMap<String, Object> errorResp = getResponse(HttpStatus.NOT_FOUND, e);
        return errorResp;
    }*/

////////////////////////////////////
/*
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object requestParamErrorHandler(HttpServletRequest req, Exception exception) throws Exception {
        LambdaException ex = new LambdaException("A0000", "系统内部错误", "系统发生错误，请联系管理员", exception)
        logger.error("请求参数错误", exception);
        return new JsonResult(new LambdaException("请求参数错误", exception));
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object requestParamErrorHandler(HttpServletRequest req, BindException exception) throws Exception {
        logger.error("请求参数错误", exception);
        //loggerException(exception);
        JsonResult jsonResult = new JsonResult(ResultCode.ERROR_REQUEST_PARAM_CANNOT_EMPTY);
        if (!exception.getAllErrors().isEmpty() && !StringUtils.isEmpty(exception.getAllErrors()
                .get(0)
                .getDefaultMessage())) {
            jsonResult.setErrorMsg(exception.getAllErrors().get(0).getDefaultMessage());
        }
        return buildResult(jsonResult, req);
    }

    @ExceptionHandler(value = VehicleException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object requestParamErrorHandler(HttpServletRequest req, VehicleException exception) throws Exception {
        loggerException(exception);
        JsonResult jsonResult;
        if (exception.getResultCode() == null) {
            jsonResult = new JsonResult(ResultCode.ERROR_GENERAL);
            jsonResult.setErrorMsg(exception.getMessage());
        } else {
            jsonResult = new JsonResult(exception.getResultCode());
        }

        return buildResult(jsonResult, req);
    }

    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Object processUnauthorizedException(HttpServletRequest req, UnauthorizedException e) {
        // loggerException(e);
        JsonResult jsonResult = JsonResult.create(ResultCode.ERROR_ROLES_AUTH);

        return buildResult(jsonResult, req);
    }

    @ExceptionHandler({UnauthenticatedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Object processUnauthenticatedException(HttpServletRequest req, UnauthenticatedException e) {
        //loggerException(e);
        JsonResult jsonResult = JsonResult.create(ResultCode.ERROR_LOGIN_AUTH);

        return buildResult(jsonResult, req);
    }*/
}
