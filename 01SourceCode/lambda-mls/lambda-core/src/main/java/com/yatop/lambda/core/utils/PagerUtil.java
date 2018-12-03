package com.yatop.lambda.core.utils;

public class PagerUtil {

    //页码1时，默认查询一次total count，小于1时全部查询，最多查询第1000页
    private int pageNo;

    //页大小，每次请求的分页大小，小于1时全部查询，每页最多1000条
    private int pageSize;

    //总记录数，页码为1时从PageHelper获取
    private long totalCount;

    public PagerUtil(int pageNo, int pageSize) {
        setPageNo(pageNo);
        setPageSize(pageSize);
        this.totalCount = -1;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo < 1000 ? pageNo : 1000;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize < 1000 ? pageSize : 1000;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isNeedTotalCount() {
        return pageNo == 1 ? pageSize > 0 : false;
    }

    public boolean isNeedPage() {
        return pageNo > 0 && pageSize > 0;
    }
}
