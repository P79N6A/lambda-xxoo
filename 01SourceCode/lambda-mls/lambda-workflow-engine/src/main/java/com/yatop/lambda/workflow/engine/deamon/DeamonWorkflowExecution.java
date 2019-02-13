package com.yatop.lambda.workflow.engine.deamon;

import com.yatop.lambda.base.model.WfExecutionJobQueue;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.mgr.workflow.execution.queue.JobQueueHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJobQueue;
import com.yatop.lambda.workflow.engine.service.ExecutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeamonWorkflowExecution {

    public static Logger logger = LoggerFactory.getLogger(DeamonWorkflowExecution.class);

    @Value("${lambda-workflow-engine.daemon.enable:false}")
    private boolean enable;

    @Value("${lambda-workflow-engine.daemon.maxRunningJobs:8}")
    private int maxRunningJobs;

    @Autowired
    ExecutionService executionService;

    @Scheduled(fixedDelay = 1000, initialDelay = 0)
    public void execute() {
        if (enable) {
            dealKillSignalJobs();
            dealRunningAndQueueingJobs();
        }
    }

    private void dealKillSignalJobs() {

        List<WfExecutionJobQueue> killJobs = JobQueueHelper.queryKillJobs();
        if(DataUtil.isEmpty(killJobs)) {
            return;
        }

        for(WfExecutionJobQueue killJob : killJobs) {

            //获取其运行中任务列表，并逐个进行kill
            executionService.processKillSignalJob(new ExecutionJobQueue(killJob));
        }
    }

    private void dealRunningAndQueueingJobs() {

        int runningjobNum = dealRunningJobs();

        if(maxRunningJobs > runningjobNum) {
            dealQueueingJobs(maxRunningJobs - runningjobNum);
        }

        //1. 扫描运行中作业，获取作业列表
        //2. 对每个作业，获取其运行中任务列表，检查任务在集群运行情况（处理中、已完成、出错），更新运行信息
    }

    private int dealRunningJobs() {

        List<WfExecutionJobQueue> runningJobs = JobQueueHelper.queryRunningJobs();
        if(DataUtil.isEmpty(runningJobs)) {
            return 0;
        }

        for(WfExecutionJobQueue runningJob : runningJobs) {

            executionService.processRunningJob(new ExecutionJobQueue(runningJob));
            //获取其运行中任务列表，检查任务在集群运行情况（处理中、已完成、出错），更新运行信息
        }

        return runningJobs.size();
    }

    private void dealQueueingJobs(int topN) {

        List<WfExecutionJobQueue> queueingJobs = JobQueueHelper.queryQueueingJobs(topN);
        if(DataUtil.isEmpty(queueingJobs)) {
            return;
        }

        for(WfExecutionJobQueue queueingJob : queueingJobs) {

            executionService.processQueueingJob(new ExecutionJobQueue(queueingJob));
        }
    }

}
