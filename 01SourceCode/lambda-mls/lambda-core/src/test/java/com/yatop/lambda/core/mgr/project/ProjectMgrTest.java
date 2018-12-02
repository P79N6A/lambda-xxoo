package com.yatop.lambda.core.mgr.project;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yatop.lambda.FramewrokApplication;
import com.yatop.lambda.base.model.PrProject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = FramewrokApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class ProjectMgrTest {

    @Autowired
    private ProjectMgr projectMgr;

    @Test
    @Transactional
    @Rollback(true)
    public void testQueryComponents() {
        PrProject project = new PrProject();
        project.setProjectCode("XXOO");
        project.setProjectName("码农的坑爹日子");
        project.setDwId(999L);
        project.setMwId(999L);

        project = projectMgr.insertProject(project, "admin");
        System.out.println("project: " + JSON.toJSONString(JSON.toJSON(project), SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat));
    }
}
