package com.yatop.lambda.portal.job.service;

import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.job.domain.JobLog;

import java.util.List;

public interface JobLogService extends IService<JobLog> {

    List<JobLog> findJobLogs(QueryRequest request, JobLog jobLog);

    void saveJobLog(JobLog log);

    void deleteJobLogs(String[] jobLogIds);
}
