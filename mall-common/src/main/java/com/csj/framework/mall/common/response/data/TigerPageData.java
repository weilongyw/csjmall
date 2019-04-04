package com.csj.framework.mall.common.response.data;

import lombok.Data;

import java.util.List;

@Data
public class TigerPageData<T> {

    private int total;

    private int pageNum;

    private int pageSize;

    private int pages;

    private int size;

    private List<T> list;


}
