package com.yatop.lambda.manager.api.request.project;

import com.yatop.lambda.core.utils.PagerUtil;

/**
 * 模型
 *
 * @author huangyu
 * @create 2019-02-28-14:30
 */
public class ModelRequest extends PagerUtil {
    private Long ownerMwId;
    private String keyword;
    private Long modelId;
    private String filePath;

    public Long getOwnerMwId() {
        return ownerMwId;
    }

    public void setOwnerMwId(Long ownerMwId) {
        this.ownerMwId = ownerMwId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
