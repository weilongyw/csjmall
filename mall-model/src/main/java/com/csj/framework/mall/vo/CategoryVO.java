package com.csj.framework.mall.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryVO implements Serializable{

    /**
     * 主键Id
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String className;


    /**
     * 分类图片
     */
    private String classPic;

}
