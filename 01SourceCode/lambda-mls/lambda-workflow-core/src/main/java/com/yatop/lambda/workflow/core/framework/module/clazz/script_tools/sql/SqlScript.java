package com.yatop.lambda.workflow.core.framework.module.clazz.script_tools.sql;

import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.module.clazz.script_tools.ScriptToolsGeneric;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class SqlScript extends ScriptToolsGeneric {

    private static String SELECT_KEYWORD = "SELECT";


    private boolean simpleValiedateSqlStmt(String sqlstmt) {

        InputStream stream = new ByteArrayInputStream(sqlstmt.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        boolean passed = true;
        try {
            String line = null;
            while ((line = reader.readLine()) != null) {

                line = DataUtil.trimLeft(line);
                if(DataUtil.isEmpty(line)) {
                    continue;
                }

                if(line.length() >= 2 && line.charAt(0) == '-' && line.charAt(1) == '-') {
                    continue;
                }

                if(line.length() >= SELECT_KEYWORD.length() && line.substring(0, SELECT_KEYWORD.length()).equalsIgnoreCase(SELECT_KEYWORD)) {
                    break;
                }

                passed = false;
                break;
            }
        } catch (Throwable e) {
            passed = false;
        } finally {
            if(DataUtil.isNotNull(reader)) {
                try {
                    reader.close();
                } catch (Throwable ex) {
                }
            }
        }

        return passed;
    }
}
