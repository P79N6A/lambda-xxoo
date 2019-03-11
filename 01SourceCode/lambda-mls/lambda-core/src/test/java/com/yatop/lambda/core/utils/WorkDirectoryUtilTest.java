package com.yatop.lambda.core.utils;

import com.yatop.lambda.LambdaApplication;
import com.yatop.lambda.core.concurrent.workflow.WorkflowNamedLockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LambdaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorkDirectoryUtilTest {

    @Test
    public void testWorkflowDirectoryUtil(){
        System.out.println(WorkDirectoryUtil.removeDfsSchemaPrefix("/user/lambda_mls/proc"));
        System.out.println(WorkDirectoryUtil.removeDfsSchemaPrefix("hdfs://127.0.0.1:9000/user/lambda_mls/proc"));
        System.out.println(WorkDirectoryUtil.addDfsSchemaPrefix("/user/lambda_mls/proc"));
        System.out.println(WorkDirectoryUtil.addDfsSchemaPrefix("hdfs://127.0.0.100:9000/user/lambda_mls/proc"));
    }
}
