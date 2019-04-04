package com.csj.framework.mall.entity.selfsupport;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SsSaleOrderItem {
    //表主键
    private String id;

    //主表主键
    private String ticketno;

    //行号
    private String itemno;

    //川商品id
    private String material;

    //商品编码
    private String materialno;

    //客户编码
    private String custommaterialno;

    //商品名称
    private String materialname;

    //规格
    private String materialrule;

    //型号
    private String materialsize;

    //品牌
    private String materialtag;

    //单位
    private String orderunit;

    //税率（%）
    private BigDecimal taxrate;

    //税额
    private BigDecimal taxamount;

    //数量
    private BigDecimal ordernum;

    //已发数量
    private BigDecimal sendnum;

    //销售单价
    private BigDecimal saleprice;

    //销售单价(运维平台获取的平台销售价)
    private BigDecimal platformsaleprice;

    //销售金额
    private BigDecimal orderamount;

    //完成标示
    private Integer closedcode;

    //计划单行号
    private String eqitemno;

    /**
     * 合同子表行号
     */
    private String elecontractitemid;

    //备注
    private String memos;

    //采购计划单数量
    private BigDecimal plannum;

    //类目名称
    private String categoryname;

    //类目编号
    private String categoryno;

    //-------------------------------------

    //已出库金额合计(数据库中暂无此字段)
    private BigDecimal lineTotalAmount;

    /**
     * 已建采购计划状态
     * 0 未建 1 全部创建 2 部分创建
     */
    private Integer createstatus;

    /**
     * 签收数量——tiger回传
     */
    private BigDecimal receiptnum;
    /**
     * 签收金额——tiger回传
     */
    private BigDecimal receiptamount;
    /**
     * 通知数量
     */
    private BigDecimal noticenum;
    /**
     * 通知金额
     */
    private BigDecimal noticeamount;
    /**
     * 出库金额——tiger回传
     */
    private BigDecimal outamount;
    /**
     * 收款金额——tiger回传
     */
    private BigDecimal recamount;

    /**
     * 开票金额
     */
    private BigDecimal invoicenum;
    /**
     * 开票金额
     */
    private BigDecimal invoiceamount;

    /**
     * 库存缺失数量
     */
    private BigDecimal lessnum;

    /**
     * 关闭数量
     */
    private BigDecimal closenum;

    /**
     * 关闭金额
     */
    private BigDecimal closeamount;

    /**
     * 可关闭数量
     */
    private BigDecimal availableclosenum;

    /**
     * 执行人id
     */
    private String executorid;

    /**
     * 执行人名称
     */
    private String executor;

    /**
     * 退货数量
     */
    private BigDecimal backnum;
    /**
     * 退货金额
     */
    private BigDecimal backamount;

    /**
     * 商品图片
     */
    private String productPicture;
}