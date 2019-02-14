package com.yatop.lambda.portal.system.service;

import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.system.domain.Test;

import java.util.List;

public interface TestService extends IService<Test> {

    List<Test> findTests();

    /**
     * 批量插入
     * @param list List<Test>
     */
    void batchInsert(List<Test> list);
}
