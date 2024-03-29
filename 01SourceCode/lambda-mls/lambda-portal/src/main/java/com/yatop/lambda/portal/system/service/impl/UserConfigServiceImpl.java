package com.yatop.lambda.portal.system.service.impl;

import com.yatop.lambda.portal.common.service.CacheService;
import com.yatop.lambda.portal.common.service.impl.BaseService;
import com.yatop.lambda.portal.system.domain.UserConfig;
import com.yatop.lambda.portal.system.service.UserConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service("userConfigService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserConfigServiceImpl extends BaseService<UserConfig> implements UserConfigService {

    @Autowired
    private CacheService cacheService;

    @Override
    public UserConfig findByUserId(String userId) {
        return this.selectByKey(Long.parseLong(userId));
    }

    @Override
    @Transactional
    public void initDefaultUserConfig(String userId) {
        UserConfig userConfig = new UserConfig();
        userConfig.setUserId(Long.valueOf(userId));
        userConfig.setColor(UserConfig.DEFAULT_COLOR);
        userConfig.setFixHeader(UserConfig.DEFAULT_FIX_HEADER);
        userConfig.setFixSiderbar(UserConfig.DEFAULT_FIX_SIDERBAR);
        userConfig.setLayout(UserConfig.DEFAULT_LAYOUT);
        userConfig.setTheme(UserConfig.DEFAULT_THEME);
        userConfig.setMultiPage(UserConfig.DEFAULT_MULTIPAGE);
        this.save(userConfig);
    }

    @Override
    @Transactional
    public void deleteByUserId(String... userIds) {
        List<String> list = Arrays.asList(userIds);
        this.batchDelete(list, "userId", UserConfig.class);
    }

    @Override
    @Transactional
    public void update(UserConfig userConfig) throws Exception {
        this.updateNotNull(userConfig);
        cacheService.saveUserConfigs(String.valueOf(userConfig.getUserId()));
    }
}
