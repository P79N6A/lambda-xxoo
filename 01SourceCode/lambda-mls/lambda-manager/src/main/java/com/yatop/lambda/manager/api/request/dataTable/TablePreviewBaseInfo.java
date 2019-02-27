package com.yatop.lambda.manager.api.request.dataTable;

public class TablePreviewBaseInfo {

	// private Integer rows;

	private Integer columns;

	private Long fileSize;

	// public Integer getRows() {
	// return rows;
	// }
	//
	// public void setRows(Integer rows) {
	// this.rows = rows;
	// }

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}
}
