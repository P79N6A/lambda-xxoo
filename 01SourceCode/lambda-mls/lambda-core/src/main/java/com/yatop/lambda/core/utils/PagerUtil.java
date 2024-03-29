package com.yatop.lambda.core.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class PagerUtil {

    //页码1时，默认查询一次total count，小于1时全部查询，最多查询第1000页
    private Integer pageNum;

    //页大小，每次请求的分页大小，小于1时全部查询，每页最多1000条
    private Integer pageSize;

    private boolean skipCount;

    private Page page;

    public PagerUtil() {
        init();
    }

    public PagerUtil(Integer pageNum, Integer pageSize) {
        init(pageNum, pageSize);
    }

    public static PagerUtil Pager4TopN(Integer topN) {
        PagerUtil pager = new PagerUtil(1, topN);
        pager.skipCount = true;
        return pager;
    }

    private void init() {
        init(1, 10);
    }

    private void init(Integer pageNo, Integer pageSize) {
        setPageNum(pageNo);
        setPageSize(pageSize);
        this.skipCount = false;
        this.page = null;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum < 1000 ? pageNum : 1000;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize < 1000 ? pageSize : 1000;
    }

    public long getTotalCount() {
        if(this.isNeedTotalCount() && DataUtil.isNotNull(this.page)) {
            return this.getPage().getTotal();
        }
        return -1;
    }

    public boolean isSkipCount() {
        return skipCount;
    }

    public boolean isNeedTotalCount() {
        return pageNum == 1 ? pageSize > 0 : false;
    }

    public boolean isNeedPage() {
        return pageNum > 0 && pageSize > 0;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public static void startPage(PagerUtil pager) {
        if(DataUtil.isNotNull(pager) && pager.isNeedPage()) {
            pager.setPage(PageHelper.startPage(pager.getPageNum(), pager.getPageSize(), (!pager.isSkipCount() && pager.isNeedTotalCount())));
        }
    }

    public static void clearPage(PagerUtil pager) {
        if(DataUtil.isNotNull(pager) && pager.isNeedPage()) {
            PageHelper.clearPage();
        }
        pager.init();
    }
}
