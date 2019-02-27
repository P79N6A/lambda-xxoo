package com.yatop.lambda.manager.api.request.dataTable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by hemf on 2017/7/14.
 */
@ApiModel
public class DwTableSchema {

	@ApiModelProperty(value = "数据表schema名称", required = true)
	private String name;

	@ApiModelProperty(value = "数据表schema类型", required = true)
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
