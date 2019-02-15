package com.yatop.lambda.portal.system.controller;

import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.controller.BaseController;
import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.exception.PortalException;
import com.yatop.lambda.portal.system.domain.Dict;
import com.yatop.lambda.portal.system.service.DictService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("dict")
public class DictController extends BaseController {

    private String message;

    @Autowired
    private DictService dictService;

    @GetMapping
    @RequiresPermissions("dict:view")
    public Map<String, Object> DictList(QueryRequest request, Dict dict) {
        return super.selectByPageNumSize(request, () -> this.dictService.findDicts(request, dict));
    }

    @Log("新增字典")
    @PostMapping
    @RequiresPermissions("dict:add")
    public void addDict(@Valid Dict dict) throws PortalException {
        try {
            this.dictService.createDict(dict);
        } catch (Exception e) {
            message = "新增字典成功";
            log.error(message, e);
            throw new PortalException(message);
        }
    }

    @Log("删除字典")
    @DeleteMapping("/{dictIds}")
    @RequiresPermissions("dict:delete")
    public void deleteDicts(@NotBlank(message = "{required}") @PathVariable String dictIds) throws PortalException {
        try {
            String[] ids = dictIds.split(",");
            this.dictService.deleteDicts(ids);
        } catch (Exception e) {
            message = "删除字典成功";
            log.error(message, e);
            throw new PortalException(message);
        }
    }

    @Log("修改字典")
    @PutMapping
    @RequiresPermissions("dict:update")
    public void updateDict(@Valid Dict dict) throws PortalException {
        try {
            this.dictService.updateDict(dict);
        } catch (Exception e) {
            message = "修改字典成功";
            log.error(message, e);
            throw new PortalException(message);
        }
    }

    @PostMapping("excel")
    @RequiresPermissions("dict:export")
    public void export(Dict dict, QueryRequest request, HttpServletResponse response) throws PortalException {
        try {
            List<Dict> dicts = this.dictService.findDicts(request, dict);
            ExcelKit.$Export(Dict.class, response).downXlsx(dicts, false);
        } catch (Exception e) {
            message = "导出Excel失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }
}
