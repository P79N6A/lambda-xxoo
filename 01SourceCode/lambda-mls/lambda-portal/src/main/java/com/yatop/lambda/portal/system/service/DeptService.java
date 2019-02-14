package com.yatop.lambda.portal.system.service;


import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.system.domain.Dept;

import java.util.List;
import java.util.Map;

public interface DeptService extends IService<Dept> {

    Map<String, Object> findDepts(QueryRequest request, Dept dept);

    List<Dept> findDepts(Dept dept, QueryRequest request);

    void createDept(Dept dept);

    void updateDept(Dept dept);

    void deleteDepts(String[] deptIds);
}
