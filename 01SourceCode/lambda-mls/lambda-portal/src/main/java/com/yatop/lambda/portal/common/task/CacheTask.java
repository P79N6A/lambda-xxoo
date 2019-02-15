package com.yatop.lambda.portal.common.task;

import com.yatop.lambda.portal.common.domain.PortalConstant;
import com.yatop.lambda.portal.common.service.RedisService;
import com.yatop.lambda.portal.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 主要用于定时删除 Redis中 key为 lambda.portal.user.active 中
 * 已经过期的 score
 */
@Slf4j
@Component
public class CacheTask {

    @Autowired
    private RedisService redisService;

    @Scheduled(fixedRate = 3600000)
    public void run() {
        try {
            String now = DateUtil.formatFullTime(LocalDateTime.now());
            redisService.zremrangeByScore(PortalConstant.ACTIVE_USERS_ZSET_PREFIX, "-inf", now);
            log.info("delete expired user");
        } catch (Exception ignore) {
        }
    }
}
