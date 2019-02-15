package com.yatop.lambda.portal.web.controller;

import com.yatop.lambda.portal.common.controller.BaseController;
import com.yatop.lambda.portal.common.domain.PortalConstant;
import com.yatop.lambda.portal.common.domain.PortalResponse;
import com.yatop.lambda.portal.common.exception.PortalException;
import com.yatop.lambda.portal.common.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@Slf4j
@Validated
@RestController
@RequestMapping("weather")
public class WeatherController extends BaseController {

    @GetMapping
    @RequiresPermissions("weather:view")
    public PortalResponse queryWeather(@NotBlank(message = "{required}") String areaId) throws PortalException {
        try {
            String data = HttpUtil.sendPost(PortalConstant.MEIZU_WEATHER_URL, "cityIds=" + areaId);
            return new PortalResponse().data(data);
        } catch (Exception e) {
            String message = "天气查询失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }
}
