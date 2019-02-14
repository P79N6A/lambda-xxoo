package com.yatop.lambda.portal.system.dao;

import com.yatop.lambda.portal.common.config.MyMapper;
import com.yatop.lambda.portal.system.domain.Role;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
	
	List<Role> findUserRole(String userName);
	
}