package com.yatop.lambda.portal.system.dao;

import com.yatop.lambda.portal.common.config.MyMapper;
import com.yatop.lambda.portal.system.domain.User;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

	List<User> findUserDetail(User user);
}