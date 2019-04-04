package com.csj.framework.mall.entity.selfsupport;

import java.io.Serializable;


public class BaseEntity implements Serializable {

    /*worker分页*/
    private Integer page;

    private Integer rpp;

    /*tiger分页*/
    private Integer pageNum;

    private Integer pageSize;

    /*scm分页 排序 分组*/
    private Integer pageindex;

    private Integer pagesize;

    private Integer oracleStart;

    private Integer oracleEnd;

    private String sortBy;

    private String groupBy;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRpp() {
        return rpp;
    }

    public void setRpp(Integer rpp) {
        this.rpp = rpp;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageindex() {
        return pageindex;
    }

    public void setPageindex(Integer pageindex) {
        this.pageindex = pageindex;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getOracleStart() {
        return oracleStart;
    }

    public void setOracleStart(Integer oracleStart) {
        this.oracleStart = oracleStart;
    }

    public Integer getOracleEnd() {
        return oracleEnd;
    }

    public void setOracleEnd(Integer oracleEnd) {
        this.oracleEnd = oracleEnd;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }
}
