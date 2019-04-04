package com.csj.framework.mall.entity.selfsupport;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author
 */
@Data
public class SsSaleOrder extends BaseEntity {

    //订单号(主键)
    private String ticketno;

    //客户id
    private String customer;

    //客户名称
    private String customername;

    //计划收货日期
    private String planarrivedate;

    //数量
    private BigDecimal sumordernum;

    //金额
    private BigDecimal sumorderamount;

    //已发数量(出库数量)
    private BigDecimal sumsendnum;

    //单据状态 --1（草稿） 0（待审核） 1(确认通过) -2（ 驳回 ）
    private Integer status;

    private String statusEnum;

    //创建人
    private String createuser;

    //创建日期
    private String createdate;

    //审核人
    private String checkuser;

    //审核日期
    private String checkdate;

    //审核意见
    private String checkadvice;

    //企业id（裕达）
    private String enterprise;

    //企业名称（裕达）
    private String enterprisename;

    //收款方式 1.货到付款/货到收款 2.货到票到付款 3.先款后货
    private Integer recmethod;

    //交货方式  1.库发（wms对接）  2.供应商直发  3.自提
    private Integer deliverway;

    //收货地址
    private String receiveaddress;

    //收货联系人
    private String linkusername;

    //收货联系电话
    private String linktel;

    //客户订单号
    private String customerorderno;

    //税额
    private BigDecimal sumtaxamount;

    //发出仓库ID
    private String store;

    //发出仓库名称
    private String storename;

    //计划单号
    private String enquiryorder;

    //完结标示
    private Integer closed;

    //备注
    private String memos;

    //是否删除
    private Integer isdelete;

    //合同号
    private String contractno;

    //采购负责人
    private String leader;

    /**
     * 业务负责人id
     */
    private String leaderid;

    //质保期
    private String warrantydate;

    //合同付款约定
    private String pagreement;

    //合同开票约定
    private String invoiceagreement;

    //质保期起算标准
    private String warrantystandard;

    //质保金比例
    private BigDecimal warrantyrate;

    //结算方式1现金,2银行转账,3银行承兑,4商业承兑,5支票
    private BigDecimal settlementmethod;

    //合同日期
    private String orderdate;

    //业务板块
    private Integer businesstype;

    private String businesstypeEnum;

    //创建人id
    private String createuserid;

    //审核人id
    private String checkuserid;

    /**
     * 收款状态——0 未收款   1 部分收款   2已收款
     */
    private Integer receivablestatus;

    // 0 未发货   1 部分发货  2 已发货 3 已签收(出库)
    private Integer sendstatus;

    // 0 未收货   1 部分收货  2 已收货(回单状态)
    private Integer recstatus;

    //客户合同号
    private String cuscontractno;

    //采购计划单总数量
    private BigDecimal sumplannum;


    //-------------------------------------------------

    //已出库金额合计(数据库中暂无此字段)
    private BigDecimal totalSendAmount;

    //已通知数量
    private BigDecimal noticenum;
    //已通知金额
    private BigDecimal noticeamount;

    //通知状态
    private Integer noticestatus;

    //合同金额字段
    private BigDecimal contractamount;

    //商城数据
    private String b2bstatusinfo;

    /**
     * 已建采购计划状态
     * 0 未建 1 全部创建 2 部分创建
     */
    private Integer createstatus;

    /**
     * 客户code
     */
    private String customcode;

    /**
     * 平台code
     */
    private String enterprisecode;


    // vo
    //开票金额
    private BigDecimal receivableamount;

    //实收金额
    private BigDecimal settlementamount;

    /**
     * 收款金额——tiger回传
     */
    private BigDecimal sumrecamount;

    /**
     * 签收数量——tiger回传
     */
    private BigDecimal sumreceiptnum;

    /**
     * 签收金额——tiger回传
     */
    private BigDecimal sumreceiptamount;

    /**
     * 签收状态
     * 0 未签收 1 部分签收 2 全部签收
     */
    private Integer receiptstatus;

    /**
     * 通知数量汇总
     */
    private BigDecimal sumnoticenum;

    /**
     * 通知金额汇总
     */
    private BigDecimal sumnoticeamount;

    /**
     *
     */
    private BigDecimal sumoutamount;

    /**
     * 发票金额-tiger回传
     */
    private BigDecimal suminvoicenum;

    /**
     * 发票金额-tiger回传
     */
    private BigDecimal suminvoiceamount;

    /**
     * 发票状态
     * 0 未付款  1部分付款  2 已付款
     */
    private Integer invoicestatus;
    /**
     * 多业务主体
     */
    private String[] enterprisecodes;

    /**
     * 业务类型
     * 1 以销定采  2 平台直营
     */
    private Integer biztype;

    private String biztypeEnum;

    /**
     * 预付款比例（%）
     */
    private BigDecimal prepaymentratio;

    /**
     * 预付款金额|合同金额* 预付比例
     */
    private BigDecimal prepayamount;

    /**
     * 订单审批流状态
     * 0 调整审批  1 主管审核  2 财务审核 3 总经理审核 4 盖章 5 业务预警 6 商务复核 7 归档
     */
    private Integer checkstatus;

    /**
     * 来源系统|0 SCM 1 商城 2 SAAS
     */
    private Integer fromsystem;

    /**
     * 附件
     */
    private JSONArray enclosure;

    /**
     * 保证金比例——新建订单时录入
     */
    private BigDecimal depositratio;

    /**
     * 保证金——前端计算传入
     */
    private BigDecimal deposit;

    /**
     * 已收保证金（销售）|已付保证金（采购）——Tiger回传写入
     */
    private BigDecimal deposited;

    /**
     * 库存缺失数量
     */
    private BigDecimal sumlessnum;

    /**
     * 流程对应id-回填
     */
    private String business;

    /**
     * 流程任务定义关键字
     */
    private String taskDefKey;

    /**
     * 流程任务定义关键字名称
     */
    private String taskDefKeyName;

    /**
     * 流程名称
     */
    private String processDefId;

    /**
     * 关闭总数量
     */
    private BigDecimal sumclosenum;

    /**
     * 关闭总金额
     */
    private BigDecimal sumcloseamount;

    /**
     * 关闭原因
     */
    private String closereason;

    /**
     * 订单合同附件（合同性质为框架合同增加必填项）
     */
    private JSONArray orgenclosure;

    /**
     * 退货数量合计
     */
    private BigDecimal sumbacknum;

    /**
     * 退货金额合计
     */
    private BigDecimal sumbackamount;

    /**
     * 退货状态
     * 0 无退货  1 部分退货  2 全部退货
     */
    private Integer backstatus;

    /**
     * 是否暂停
     */
    private Integer isstop;

    /**
     * 归档流程id
     */
    private String filedbusiness;

    private String backstatusEnum;


    private List<SsSaleOrderItem> saleOrderItemList;

}