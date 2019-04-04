package com.csj.framework.mall.entity.selfsupport;

import lombok.Data;

/**
 * @program: core-framework-parent
 * @description: 商城企业注册实体类
 * @author: yewei
 * @create: 2019-03-11 17:00
 */
@Data
public class SsEnterprice extends BaseEntity {

    /**
     * 客户id
     */
    private String requestId;

    /**
     * 企业名称（需查重）
     */
    private String entName;
    /**
     * 企业编码
     */
    private String entNumber;
    /**
     * 企业类型
     */
    private Integer entType;
    /**
     * 注册地址
     */
    private String registerAddress;
    /**
     * 联系电话
     */
    private String linkPhone;
    /**
     * 联系人
     */
    private String linkName;
    /**
     * 法人
     */
    private String legalPerson;
    /**
     * 法人电话
     */
    private String legalPersonPhone;
    /**
     * 营业执照号(需查重)
     */
    private String businessLicenseNo;
    /**
     * 注册资本
     */
    private String registerMoney;
    /**
     * 纳税人识别号（需查重）
     */
    private String taxpayerId;
    /**
     * 营业执照附件
     */
    private String attachmentUrl;
    /**
     * '是否开通采购(0：未勾选，1：已勾选)',
     */
    private Integer purchase;
    /**
     * 供应商业务分类（1：合格(优质)供应商，2：试用供应商（备用供应商），3：战略合作供应商（独家/客户指定供应商），4：特批供应商,5:合格(普通)供应商）',
     */
    private Integer supplyBusiness;
    /**
     * 供应商状态分类(1：活跃供应商，2：冻结供应商，3：黑名单供应商)
     */
    private Integer supplyState;
    /**
     * 是否启用 0-停用 1-启用
     */
    private String isValid;
    /**
     * 审核状态 8-归档
     */
    private String checkStatus;
    /**
     * 业务负责人ID
     */
    private String businessPrincipalId;
    /**
     * 业务负责人名字
     */
    private String businessPrincipal;


}
