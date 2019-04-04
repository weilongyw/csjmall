package com.csj.framework.mall.entity.selfsupport;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SsPayment {
    /**
     * 收款单号
     * isNullAble:0
     */
    private String receiveNo;
    /**
     * 付款方ID
     * isNullAble:0
     */
    private String paymenterId;
    /**
     * 付款方
     * isNullAble:0
     */
    private String paymenterName;
    /**
     * 付款方式 1：银行转账，2：支票，3：现金，4：承兑
     * isNullAble:0
     */
    private Byte paymentMode;
    /**
     * 付款方银行
     * isNullAble:0
     */
    private String paymentBank;
    /**
     * 付款方账号
     * isNullAble:0
     */
    private String paymentAccount;
    /**
     * 付款金额
     * isNullAble:1,defaultVal:0.00
     */
    private BigDecimal paymentAmt;
    /**
     * 付款日期
     * isNullAble:0
     */
    private Date paymentDate;
    /**
     * 交易流水号
     * isNullAble:0
     */
    private String paymentRecordNo;
    /**
     * 付款摘要
     * isNullAble:1
     */
    private String paymentAbstract;
    /**
     * 录入人ID
     * isNullAble:0
     */
    private String inputUserId;
    /**
     * 录入人姓名
     * isNullAble:0
     */
    private String inputUserName;
    /**
     * 录入时间
     * isNullAble:0
     */
    private Date inputTime;
    /**
     * 审核状态 0:保存；1:未审核；2:审核通过；3:驳回
     */
    private Byte approveStatus;
    /**
     * 审核建议
     */
    private String approveInfo;
    /**
     * 审核人ID
     * isNullAble:0,defaultVal:0
     */
    private String approveUserId;
    /**
     * 审核人
     * isNullAble:0,defaultVal:0
     */
    private String approveUserName;
    /**
     * 审核时间
     * isNullAble:0,defaultVal:2018-01-01 00:00:00
     */
    private Date approveTime;
    /**
     * 关联状态 0：待分配业务员，1：未关联，2：保存，3：待复核，4：已复核，5：已驳回
     * isNullAble:0
     */
    private Byte relationStatus;
    /**
     * 复核建议
     */
    private String relationApproveInfo;
    /**
     * 销售单关联人ID
     * isNullAble:1
     */
    private String relationUserId;
    /**
     * 销售单关联人
     * isNullAble:1
     */
    private String relationUserName;
    /**
     * 销售单关联时间
     * isNullAble:0,defaultVal:2018-01-01 00:00:00
     */
    private Date relationDate;
    /**
     * 款项性质 0:货款 1:质保金 2:服务费
     * isNullAble:0
     */
    private Byte moneyState;
    /**
     * 款项类型 0:预付款 1:提货款 2:保证金
     * isNullAble:0
     */
    private Byte moneyType;
    /**
     * 货款总金额
     * isNullAble:1,defaultVal:0.00
     */
    private BigDecimal sumPayableAmt;
    /**
     * 贴息总金额
     * isNullAble:1,defaultVal:0.00
     */
    private BigDecimal sumInterestAmt;
    /**
     * 备注
     * isNullAble:1
     */
    private String remarkInfo;
    /**
     * 货主编号
     */
    private String ownerCode;
    /**
     * 货主名称
     */
    private String ownerName;


}

