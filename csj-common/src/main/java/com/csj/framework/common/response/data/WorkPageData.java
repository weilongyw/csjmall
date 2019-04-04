package com.csj.framework.common.response.data;

import lombok.Data;

import java.util.List;

@Data
public class WorkPageData<T> {

    private int pageSize;

    private int pageNum;

    private int total;

    private int pages;

    private int size;

    private Boolean hasNexPage;

    private Boolean hasPrePage;

    private Boolean firstPage;

    private Boolean lastPage;

    private List<T> list;

}
