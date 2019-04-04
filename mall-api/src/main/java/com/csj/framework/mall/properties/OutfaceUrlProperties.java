package com.csj.framework.mall.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "url")
@Data
public class OutfaceUrlProperties {

    /**
     * 分类列表
     */
    private String categoryList;
    /**
     * 商品列表
     */
    private String productSkuList;
    /**
     * 品牌
     */
    private String brandList;
    /**
     * 企业注册
     */
    private String entReg;
    /**
     * 企业查询
     */
    private String entSearch;
    /**
     * 创建采购订单
     */
    private String createSaleOrder;
    /**
     * 查询采购订单
     */
    private String searchSaleOrder;
    /**
     * 查询发票
     */
    private String searchInvoice;
    /**
     * 分类列表
     */
    private String searchOutplan;
    /**
     * 查询出库计划
     */
    private String searchPayment;
    /**
     * 查询出库单
     */
    private String searchOut;
    /**
     * 查询物流信息
     */
    private String searchDelivery;


}


