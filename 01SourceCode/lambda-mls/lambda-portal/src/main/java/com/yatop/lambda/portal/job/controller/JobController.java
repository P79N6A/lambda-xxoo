package com.yatop.lambda.portal.job.controller;

import com.yatop.lambda.portal.common.annotation.Log;
import com.yatop.lambda.portal.common.controller.BaseController;
import com.yatop.lambda.portal.common.domain.QueryRequest;
import com.yatop.lambda.portal.common.exception.PortalException;
import com.yatop.lambda.portal.job.domain.Job;
import com.yatop.lambda.portal.job.service.JobService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.quartz.CronExpression;
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
@RequestMapping("job")
public class JobController extends BaseController {

    private String message;

    @Autowired
    private JobService jobService;

    @GetMapping
    @RequiresPermissions("job:view")
    public Map<String, Object> jobList(QueryRequest request, Job job) {
        return super.selectByPageNumSize(request, () -> this.jobService.findJobs(request, job));
    }

    @GetMapping("cron/check")
    public boolean checkCron(String cron) {
        try {
            return CronExpression.isValidExpression(cron);
        } catch (Exception e) {
            return false;
        }
    }

    @Log("新增定时任务")
    @PostMapping
    @RequiresPermissions("job:add")
    public void addJob(@Valid Job job) throws PortalException {
        try {
            this.jobService.createJob(job);
        } catch (Exception e) {
            message = "新增定时任务失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }

    @Log("删除定时任务")
    @DeleteMapping("/{jobIds}")
    @RequiresPermissions("job:delete")
    public void deleteJob(@NotBlank(message = "{required}") @PathVariable String jobIds) throws PortalException {
        try {
            String[] ids = jobIds.split(",");
            this.jobService.deleteJobs(ids);
        } catch (Exception e) {
            message = "删除定时任务失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }

    @Log("修改定时任务")
    @PutMapping
    @RequiresPermissions("job:update")
    public void updateJob(@Valid Job job) throws PortalException {
        try {
            this.jobService.updateJob(job);
        } catch (Exception e) {
            message = "修改定时任务失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }

    @Log("执行定时任务")
    @GetMapping("run/{jobId}")
    @RequiresPermissions("job:run")
    public void runJob(@NotBlank(message = "{required}") @PathVariable String jobId) throws PortalException {
        try {
            this.jobService.run(jobId);
        } catch (Exception e) {
            message = "执行定时任务失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }

    @Log("暂停定时任务")
    @GetMapping("pause/{jobId}")
    @RequiresPermissions("job:pause")
    public void pauseJob(@NotBlank(message = "{required}") @PathVariable String jobId) throws PortalException {
        try {
            this.jobService.pause(jobId);
        } catch (Exception e) {
            message = "暂停定时任务失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }

    @Log("恢复定时任务")
    @GetMapping("resume/{jobId}")
    @RequiresPermissions("job:resume")
    public void resumeJob(@NotBlank(message = "{required}") @PathVariable String jobId) throws PortalException {
        try {
            this.jobService.resume(jobId);
        } catch (Exception e) {
            message = "恢复定时任务失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }

    @PostMapping("excel")
    @RequiresPermissions("job:export")
    public void export(Job job, QueryRequest request, HttpServletResponse response) throws PortalException {
        try {
            List<Job> jobs = this.jobService.findJobs(request, job);
            ExcelKit.$Export(Job.class, response).downXlsx(jobs, false);
        } catch (Exception e) {
            message = "导出Excel失败";
            log.error(message, e);
            throw new PortalException(message);
        }
    }
}
