package com.yatop.lambda.core.util;

import com.yatop.lambda.base.mapper.extend.DatabaseTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;

public class DateTimeUtil {

    @Autowired
    private DatabaseTimeMapper databaseTimeMapper;

    public Timestamp getCurrentTimeMillis() {
        return databaseTimeMapper.getCurrentTimestamp();
    }

    public Date getCurrentTime() {
        return databaseTimeMapper.getCurrentTime();
    }
}
