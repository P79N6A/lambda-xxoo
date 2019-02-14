package com.yatop.lambda.portal.job.service;

import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.job.domain.Job;

import java.util.List;

public interface JobService extends IService<Job> {

    Job findJob(Long jobId);

    List<Job> findJobs(QueryRequest request, Job job);

    void createJob(Job job);

    void updateJob(Job job);

    void deleteJobs(String[] jobIds);

    int updateBatch(String jobIds, String status);

    void run(String jobIds);

    void pause(String jobIds);

    void resume(String jobIds);

}
