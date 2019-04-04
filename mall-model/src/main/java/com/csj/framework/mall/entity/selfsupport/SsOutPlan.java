package com.csj.framework.mall.entity.selfsupport;

import lombok.Data;

import java.util.Date;

@Data
public class SsOutPlan extends BaseEntity {

    /**
     * 业务单号
     */
    private String busiBillNo;

    private Integer busiBusiType;
    /**
     * 订单性质：1、以销定采，2、平台直营
     */
    private Integer busiBillNature;

    private Integer deliverWay;
    /**
     * 计划制定人
     */
    private String planName;

    private Date planTime;
    /**
     * 计划单号
     */
    private String planCode;

    private String planWarehouseCode;
    /**
     * 仓库名称
     */
    private String planWarehouseName;
    /**
     * 货主编号
     */
    private String ownerCode;
    /**
     * 货主名称
     */
    private String ownerName;
    /**
     * 下推状态
     */
    private Integer issuedState;

    private String issuedStoreSys;

    private Integer hangUpType;
    /**
     * 执行状态
     */
    private Integer execStatus;

    private Integer arrivalType;
    /**
     * 客户(供应商)编码
     */
    private String arrivalCode;
    /**
     * 客户(供应商)企业
     */
    private String arrivalName;
    /**
     * 客户(供应商)联系人
     */
    private String arrivalLinkName;

    private String arrivalLinkTel;

    private String arrivalEmail;

    private String arrivalProvince;

    private String arrivalCity;

    private String arrivalDistrict;

    private String arrivalStreet;
    /**
     * 客户(供应商)地址
     */
    private String arrivalAddress;

    private Date planOutTime;

    private Date lastOutTime;

    private String warehouseCode;

    private String fromSysCode;

    private Integer signState;

    private String errorMsg;

    private String operateToken;

    private Integer planState;

    private String reason;

    private String contractNo;

    private Integer busiPlate;

    private String remarkInfo;

    private String busiBillCreater;
}
