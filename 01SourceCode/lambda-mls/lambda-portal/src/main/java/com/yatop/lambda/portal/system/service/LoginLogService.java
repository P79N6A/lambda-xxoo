package com.yatop.lambda.portal.system.service;

import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.system.domain.LoginLog;

public interface LoginLogService extends IService<LoginLog> {

    void saveLoginLog (LoginLog loginLog);
}
