package com.yatop.lambda.core.util;

import com.yatop.lambda.base.mapper.extend.DatabaseTimeMapper;
import com.yatop.lambda.core.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class DateTimeUtilTest {

    @Autowired
    private DatabaseTimeMapper databaseTimeMapper;

    @Test
    public void testDatabaseTime() {
        //DateTimeUtilTest dateTimeUtil = new DateTimeUtilTest();
        Timestamp timestamp = databaseTimeMapper.getCurrentTimestamp();
        System.out.println("getCurrentTimeMillis: " + timestamp);

        Date date = databaseTimeMapper.getCurrentTime();
        System.out.println("getCurrentTime: " + date);
    }
}
