package com.csj.framework.mall.entity.selfsupport;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SsBrand implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String brandId;

    private String brandName;

    private JSONArray brandPic;

    private String brandInfo;

    private JSONArray brandCa;

    private String createUserId;

    private Date createTime;

    private String editUserId;

    private Date editTime;

    private String requestId;

    private Integer categoryId;

    private Integer isAuthorize;
}