package com.yatop.lambda.portal.web.controller;

import com.yatop.lambda.portal.common.domain.PortalConstant;
import com.yatop.lambda.portal.common.domain.PortalResponse;
import com.yatop.lambda.portal.common.exception.PortalException;
import com.yatop.lambda.portal.common.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("article")
public class ArticleController {

    @GetMapping
    @RequiresPermissions("article:view")
    public PortalResponse queryArticle(String date) throws PortalException {
        String param;
        String data;
        try {
            if (StringUtils.isNotBlank(date)) {
                param = "dev=1&date=" + date;
                data = HttpUtil.sendSSLPost(PortalConstant.MRYW_DAY_URL, param);
            } else {
                param = "dev=1";
                data = HttpUtil.sendSSLPost(PortalConstant.MRYW_TODAY_URL, param);
            }
            return new PortalResponse().data(data);
        } catch (Exception e) {
            String message = "获取文章失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }
}
