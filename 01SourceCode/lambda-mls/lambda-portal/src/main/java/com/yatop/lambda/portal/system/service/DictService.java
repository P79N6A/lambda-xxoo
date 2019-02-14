package com.yatop.lambda.portal.system.service;

import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.service.IService;
import com.yatop.lambda.portal.system.domain.Dict;

import java.util.List;

public interface DictService extends IService<Dict> {

    List<Dict> findDicts(QueryRequest request, Dict dict);

    void createDict(Dict dict);

    void updateDict(Dict dicdt);

    void deleteDicts(String[] dictIds);

}
