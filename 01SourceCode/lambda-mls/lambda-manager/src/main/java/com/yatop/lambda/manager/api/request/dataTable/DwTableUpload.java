package com.yatop.lambda.manager.api.request.dataTable;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by hemf on 2017/6/6.
 */
public class DwTableUpload implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "上传的文件名称", required = true)
	private String fileName;

	@ApiModelProperty(value = "文件路径", required = true)
	private String filePath;

	@ApiModelProperty(value = "文件路径,类型:0-Parquet,1-CSV,2-TSV", required = true)
	private Integer fileType;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

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
}
