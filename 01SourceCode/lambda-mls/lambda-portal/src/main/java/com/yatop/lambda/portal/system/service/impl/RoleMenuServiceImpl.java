package com.yatop.lambda.portal.system.service.impl;

import com.yatop.lambda.portal.common.service.impl.BaseService;
import com.yatop.lambda.portal.system.domain.RoleMenu;
import com.yatop.lambda.portal.system.service.RoleMenuServie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

@Service("roleMenuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleMenuServiceImpl extends BaseService<RoleMenu> implements RoleMenuServie {

	@Override
	@Transactional
	public void deleteRoleMenusByRoleId(String[] roleIds) {
		List<String> list = Arrays.asList(roleIds);
		this.batchDelete(list, "roleId", RoleMenu.class);
	}

	@Override
	@Transactional
	public void deleteRoleMenusByMenuId(String[] menuIds) {
		List<String> list = Arrays.asList(menuIds);
		this.batchDelete(list, "menuId", RoleMenu.class);
	}

	@Override
	public List<RoleMenu> getRoleMenusByRoleId(String roleId) {
		Example example = new Example(RoleMenu.class);
		example.createCriteria().andCondition("role_id=",roleId);
		return this.selectByExample(example);
	}

}
