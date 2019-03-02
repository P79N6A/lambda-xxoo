package com.yatop.lambda.manager.api.request.dataTable;

/**
 * Created by xiaom on 2019/2/27.
 */
public class DwTablePreviewRequest {

    private String filePath;
    private Integer fileType;
    private Integer encodingFormat;
    private Boolean existsHeader;
    private Integer limit;


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public Integer getEncodingFormat() {
        return encodingFormat;
    }

    public void setEncodingFormat(Integer encodingFormat) {
        this.encodingFormat = encodingFormat;
    }

    public Boolean getExistsHeader() {
        return existsHeader;
    }

    public void setExistsHeader(Boolean existsHeader) {
        this.existsHeader = existsHeader;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
