package com.yatop.lambda.manager.api.request.dataTable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by hemf on 2017/6/6.
 */
@ApiModel
public class DwTablePreview {

	@ApiModelProperty(value = "数据表schema", required = true)
	private List<DwTableSchema> schema;

	@ApiModelProperty(value = "数据表内容", required = true)
	private List<List<Object>> records;

	@ApiModelProperty(value = "数据表基本信息", required = true)
	private TablePreviewBaseInfo baseinfo;

	public List<DwTableSchema> getSchema() {
		return schema;
	}

	public void setSchema(List<DwTableSchema> schema) {
		this.schema = schema;
	}

	public List<List<Object>> getRecords() {
		return records;
	}

	public void setRecords(List<List<Object>> records) {
		this.records = records;
	}

	public TablePreviewBaseInfo getBaseinfo() {
		return baseinfo;
	}

	public void setBaseinfo(TablePreviewBaseInfo baseinfo) {
		this.baseinfo = baseinfo;
	}


	public void setBaseinfo(Integer columns, Long fileSize) {
		baseinfo = new TablePreviewBaseInfo();
		baseinfo.setColumns(columns);
		baseinfo.setFileSize(fileSize);
	}
}