package com.yatop.lambda.portal.system.service.impl;

import com.yatop.lambda.portal.common.service.impl.BaseService;
import com.yatop.lambda.portal.common.utils.AddressUtil;
import com.yatop.lambda.portal.common.utils.HttpContextUtil;
import com.yatop.lambda.portal.common.utils.IPUtil;
import com.yatop.lambda.portal.system.domain.LoginLog;
import com.yatop.lambda.portal.system.service.LoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service("loginLogService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LoginLogServiceImpl extends BaseService<LoginLog> implements LoginLogService {

    @Override
    @Transactional
    public void saveLoginLog(LoginLog loginLog) {
        loginLog.setLoginTime(new Date());
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String ip = IPUtil.getIpAddr(request);
        loginLog.setIp(ip);
        loginLog.setLocation(AddressUtil.getCityInfo(ip));
        this.save(loginLog);
    }
}
