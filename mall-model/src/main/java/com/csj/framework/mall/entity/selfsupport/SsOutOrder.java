package com.csj.framework.mall.entity.selfsupport;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class SsOutOrder {

    /**
     * 计划单号
     */
    private String planCode;
    /**
     * 制单人
     */
    private String busiBillName;
    /**
     * 制定时间
     */
    private String busiBillTime;
    /**
     * 业务单号
     */
    private String busiBillNo;
    /**
     * 业务类型
     */
    private Integer busiBillType;
    /**
     * 业务板块
     */
    private Integer busiPlate;
    /**
     * 合同编号
     */
    private String contractNo;
    /**
     * 出库时间
     */
    private String outStoreTime;
    /**
     * 货主编号
     */
    private String ownerCode;
    /**
     * 货主名称
     */
    private String ownerName;
    /**
     * 仓库编号
     */
    private String warehouseNo;
    /**
     * 仓库编号
     */
    private String warehouseName;
    /**
     * 仓库系统
     */
    private String warehouseSys;
    /**
     * 仓库操作单号
     */
    private String warehouseExeCode;
    /**
     * 是否越库
     */
    private Integer isCross;
    /**
     * 出库状态
     */
    private Integer billStatus;
    /**
     * 客户(供应商)编码
     */
    private String arrivalCode;
    /**
     * 客户(供应商)联系人
     */
    private String arrivalName;
    /**
     * 客户(供应商)联系人电话
     */
    private String arrivalLinkTel;
    /**
     * 客户(供应商)地址
     */
    private String arrivalAddress;

    //出库金额
    private BigDecimal outAmt;

    //出库数量
    private BigDecimal outQty;

    /**
     * 物流信息
     */
    private SsDeliveryInfo deliveryInfo;

    private List<SsOutOrderItem> orderDetails;
}
