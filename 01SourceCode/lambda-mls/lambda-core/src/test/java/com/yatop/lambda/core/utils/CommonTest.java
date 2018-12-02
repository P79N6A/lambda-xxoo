package com.yatop.lambda.core.utils;

import com.yatop.lambda.FramewrokApplication;
import com.yatop.lambda.core.mgr.project.ProjectMgr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = FramewrokApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class CommonTest {

    //@Autowired
    //ProjectMgr projectMgr;

    @Test
    public void testMethod() {
/*        try {
            //StackTraceElement[] e = Thread.currentThread().getStackTrace();
            //System.out.println(Thread.currentThread() .getStackTrace()[1].getClassName() + "." + Thread.currentThread() .getStackTrace()[1].getMethodName());
            System.out.println(ErrorMessage.generateErrorMessage("test"));
            throw new Exception("hahaha");
        } catch (Throwable e) {
            System.out.println(ErrorMessage.generateErrorMessage("exception"));
        }*/

        /*try {
            projectMgr.createProject(null);
        } catch (Throwable e) {
            e.printStackTrace();
        }*/

        System.out.println("substring: " + "abc".substring(0,0).length());
    }
}
