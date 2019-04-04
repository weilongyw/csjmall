package com.csj.framework.mall.entity.selfsupport;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 1-3级分类 json model
 */
@Data
public class SsCategory extends BaseEntity{
    /**
     * 主键Id
     */
    private Integer id;
    /**
     * 分类编码
     */
    private String classCode;
    /**
     * 分类名称
     */
    private String className;
    /**
     * 分类简写
     */
    private String simpleName;

    /**
     * 上层分类ID
     */
    private Integer parentClass;
    /**
     * 分类层级
     */
    private Integer levelNum;
    /**
     * 备注
     */
    private String memos;

    /**
     *
     */
    private String createUserId;

    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private String editUserId;
    /**
     *
     */
    private Date editTime;

    /**
     * udf相关规则{key:key,type:type,value:{}}
     */
    private JSONObject udf1;

    /**
     *
     */
    private JSONObject udf2;

    /**
     *
     */
    private JSONObject udf3;

    /**
     *
     */
    private JSONObject udf4;

    /**
     *
     */
    private JSONObject udf5;

    /**
     *
     */
    private JSONObject udf6;

    /**
     *
     */
    private JSONObject udf7;

    /**
     *
     */
    private JSONObject udf8;

    /**
     *
     */
    private JSONObject udf9;

    /**
     *
     */
    private JSONObject udf10;

    /**
     * 迁移数据标识
     */
    private String requestId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 1启用 0停用
     */
    private Integer state;

    private List<SsCategory> children;

}
