package com.yatop.lambda.portal.system.service;


import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.system.domain.UserRole;

import java.util.List;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String[] roleIds);

	void deleteUserRolesByUserId(String[] userIds);

	List<String> findUserIdsByRoleId(String[] roleIds);
}
