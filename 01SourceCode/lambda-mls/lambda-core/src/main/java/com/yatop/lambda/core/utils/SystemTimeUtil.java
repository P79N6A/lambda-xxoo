package com.yatop.lambda.core.utils;

import com.yatop.lambda.base.extend.mapper.ExtDatabaseTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class SystemTimeUtil {

    static private ExtDatabaseTimeMapper extDatabaseTimeMapper;

    @Autowired
    public void setDatabaseTimeMapper(ExtDatabaseTimeMapper extDatabaseTimeMapper) {
        SystemTimeUtil.extDatabaseTimeMapper = extDatabaseTimeMapper;
    }

    static public Timestamp getCurrentTimeMillis() {
        return extDatabaseTimeMapper.getCurrentTimestamp();
    }

    static public Date getCurrentTime() {
        return extDatabaseTimeMapper.getCurrentTime();
    }
}
