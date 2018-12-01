package com.yatop.lambda.core.utils;

import com.yatop.lambda.base.mapper.extend.DatabaseTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class SystemTimeUtil {

    @Autowired
    private DatabaseTimeMapper databaseTimeMapper;

    public Timestamp getCurrentTimeMillis() {
        return databaseTimeMapper.getCurrentTimestamp();
    }

    public Date getCurrentTime() {
        return databaseTimeMapper.getCurrentTime();
    }
}
