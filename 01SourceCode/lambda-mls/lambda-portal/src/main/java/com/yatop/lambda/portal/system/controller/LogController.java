package com.yatop.lambda.portal.system.controller;

import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.controller.BaseController;
import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.exception.PortalException;
import com.yatop.lambda.portal.system.domain.SysLog;
import com.yatop.lambda.portal.system.service.LogService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("log")
public class LogController extends BaseController {

    private String message;

    @Autowired
    private LogService logService;

    @GetMapping
    @RequiresPermissions("log:view")
    public Map<String, Object> logList(QueryRequest request, SysLog log) {
        return super.selectByPageNumSize(request, () -> this.logService.findLogs(request, log));
    }

    @Log("删除系统日志")
    @DeleteMapping("/{ids}")
    @RequiresPermissions("log:delete")
    public void deleteLogss(@NotBlank(message = "{required}") @PathVariable String ids) throws PortalException {
        try {
            String[] logIds = ids.split(",");
            this.logService.deleteLogs(logIds);
        } catch (Exception e) {
            message = "删除日志失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }

    @PostMapping("excel")
    @RequiresPermissions("log:export")
    public void export(SysLog sysLog, QueryRequest request, HttpServletResponse response) throws PortalException {
        try {
            List<SysLog> sysLogs = this.logService.findLogs(request, sysLog);
            ExcelKit.$Export(SysLog.class, response).downXlsx(sysLogs, false);
        } catch (Exception e) {
            message = "导出Excel失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }
}
