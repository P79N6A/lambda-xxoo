package com.yatop.lambda.portal.system.dao;

import com.yatop.lambda.portal.common.config.MyMapper;
import com.yatop.lambda.portal.system.domain.Dept;

public interface DeptMapper extends MyMapper<Dept> {

	/**
	 * 递归删除部门
	 *
	 * @param deptId deptId
	 */
	void deleteDepts(String deptId);
}