package com.yatop.lambda.manager.api.request.project;

import com.yatop.lambda.core.utils.PagerUtil;

import java.io.Serializable;

/**
 * Created by 19016 on 2019/2/1.
 */
public class ProjectRequest extends PagerUtil {

    private Long projectId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
