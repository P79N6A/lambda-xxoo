package com.yatop.lambda.manager.controller;

import com.yatop.lambda.manager.api.request.project.ModelRequest;
import com.yatop.lambda.manager.api.response.JsonResponse;
import com.yatop.lambda.manager.api.response.PagerResponse;
import com.yatop.lambda.manager.service.ModelService;
import com.yatop.lambda.portal.common.annotation.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 模型
 *
 * @author huangyu
 * @create 2019-02-28-14:30
 */
@RestController
@RequestMapping("/model")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @Log("查询模型（分页）")
    @RequestMapping("/query")
    public JsonResponse query(@RequestBody ModelRequest vo) {
        return PagerResponse.build(modelService.query(vo), vo);
    }

    @Log("模型删除")
    @RequestMapping("/delete")
    public JsonResponse delete(@RequestBody List<Long> modelIds) {
        return JsonResponse.build(modelService.delete(modelIds));
    }

    @Log("查询模型（概述和分析报告）")
    @RequestMapping("/queryModelInfo")
    public JsonResponse queryModelInfo(@RequestBody ModelRequest vo) {
        return JsonResponse.build(modelService.queryModelInfo(vo));
    }
}
