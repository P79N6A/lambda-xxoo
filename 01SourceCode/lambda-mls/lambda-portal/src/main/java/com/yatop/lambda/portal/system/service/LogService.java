package com.yatop.lambda.portal.system.service;

import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.system.domain.SysLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface LogService extends IService<SysLog> {

    List<SysLog> findLogs(QueryRequest request, SysLog log);

    void deleteLogs(String[] logIds);

    @Async
    void saveLog(ProceedingJoinPoint point, SysLog log) throws JsonProcessingException;
}
