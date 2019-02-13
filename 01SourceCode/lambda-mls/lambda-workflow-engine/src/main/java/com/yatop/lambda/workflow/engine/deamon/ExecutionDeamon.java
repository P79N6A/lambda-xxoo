package com.yatop.lambda.workflow.engine.deamon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ExecutionDeamon {

    public static Logger logger = LoggerFactory.getLogger(ExecutionDeamon.class);

    @Value("${lambda.mls.workflow.daemon.enable:false}")
    private boolean enable;

    @Scheduled(fixedDelay = 1600, initialDelay = 3200)
    public void execute() {
        if (enable) {
            dealKillSignalJobs();
            dealRunningAndQueueingJobs();
        }
    }

    private void dealKillSignalJobs() {

        //1. 扫描KILL_SIG作业，获取作业列表
        //2. 对每个作业，获取其运行中任务列表，并逐个进行kill
    }

    private void dealRunningAndQueueingJobs() {

        //1. 扫描运行中作业，获取作业列表
        //2. 对每个作业，获取其运行中任务列表，检查任务在集群运行情况（处理中、已完成、出错），
    }


}
