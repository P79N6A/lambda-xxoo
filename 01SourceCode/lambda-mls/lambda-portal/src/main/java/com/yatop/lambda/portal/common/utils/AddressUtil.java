package com.yatop.lambda.portal.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;

@Slf4j
public class AddressUtil {

    private static final DbSearcher DB_SEARCHER = getDbSearcher();

    private static DbSearcher getDbSearcher() {

        try {
            String dbPath = AddressUtil.class.getResource("/ip2region/ip2region.db").getPath();
            File file = new File(dbPath);
            if (!file.exists()) {
                String tmpDir = System.getProperties().getProperty("java.io.tmpdir");
                dbPath = tmpDir + "ip.db";
                file = new File(dbPath);
                ClassPathResource resource = new ClassPathResource("ip2region/ip2region.db");
                InputStream inputStream = resource.getInputStream();
                FileUtils.copyInputStreamToFile(inputStream, file);
            }
            DbConfig config = new DbConfig();
            DbSearcher searcher = new DbSearcher(config, file.getPath());
            return searcher;
        } catch (Throwable e) {
            log.error("初始化地址数据库异常：{}", e);
            System.exit(-1);
            return null;
        }
    }

    public static String getCityInfo(String ip) {
        try {
            int algorithm = DbSearcher.BTREE_ALGORITHM;
            Method method = null;
            switch (algorithm) {
                case DbSearcher.BTREE_ALGORITHM:
                    method = DB_SEARCHER.getClass().getMethod("btreeSearch", String.class);
                    break;
                case DbSearcher.BINARY_ALGORITHM:
                    method = DB_SEARCHER.getClass().getMethod("binarySearch", String.class);
                    break;
                case DbSearcher.MEMORY_ALGORITYM:
                    method = DB_SEARCHER.getClass().getMethod("memorySearch", String.class);
                    break;
                default:
                    method = DB_SEARCHER.getClass().getMethod("memorySearch", String.class);
                    break;
            }
            DataBlock dataBlock = null;
            if (!Util.isIpAddress(ip)) {
                log.info("Error: Invalid ip address");
            }
            dataBlock = (DataBlock) method.invoke(DB_SEARCHER, ip);
            return dataBlock.getRegion();
        } catch (Exception e) {
            log.warn("获取地址信息异常：{}", e);
        }
        return "";
    }

}