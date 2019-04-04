package com.csj.framework.mall.entity.selfsupport;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SsInvoice {

    /**
     * 发票登记号
     */
    private String invoiceCode;
    /**
     * 开票申请单号
     */
    private String applyCode;
    /**
     * 发票编号
     */
    private String invoiceNo;
    /**
     * 客户名称
     */
    private String cusName;
    /**
     * 开票金额
     */
    private BigDecimal realInvoiceAmt;

    /**
     * 税额
     */
    private BigDecimal realInvoiceTaxAmt;

    /**
     * 开票数量
     */
    private BigDecimal numberOfInvoices;

    /**
     * 发票性质 1 蓝字发票  2  红字发票',
     */
    private Integer invoiceNature;
    /**
     * 发票状态
     */
    private Integer ticketStatus;
    /**
     * 开票时间
     */
    private Date ticketTime;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 出库单号
     */
    private String outBusiBillNo;
    /**
     * 发票类型 1  增值税专用发票  2  增值税普通发票 3  普通发票 4 无票收入
     */
    private Integer invoiceType;
    /**
     * 开票人
     */
    private String issuer;
    /**
     * 合同编号
     **/
    private String contractNo;
    /**
     * 申请作废状态   0：未申请  1申请中  2申请通过 3被驳回* isNullAble:1
     */
    private Integer invoiceCancelStatus;
    /**
     * 是发票状态    0 正常  1被红冲  2作废* isNullAble:0
     */
    private Integer invoiceStatus;
    /**
     * 是否开票
     **/
    private Boolean whetherToInvoice;
    /**
     * 数据创建时间
     **/
    private Date gmtCreate;
    /**
     * 创建人
     **/
    private String createrName;
    /**
     * 货主编号
     **/
    private String ownerCode;
    /**
     * 货主编号
     **/
    private String ownerName;
    /**
     * 业务板块：0 钢铁 1汽车
     **/
    private Integer busiPlate;
    // 已录入收票总金额
    private BigDecimal enterTotalAmount;

    // 待登记金额
    private BigDecimal amountToBeRegistered;

    // 共计发票张数
    private BigDecimal sumInvoiceQty;

    // 共计蓝票张数
    private BigDecimal sumBlueInvoiceQty;

    // 共计红票张数
    private BigDecimal sumRedInvoiceQty;

}
