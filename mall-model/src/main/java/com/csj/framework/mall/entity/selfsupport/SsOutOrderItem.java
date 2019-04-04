package com.csj.framework.mall.entity.selfsupport;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SsOutOrderItem {

    /**
     * 业务单号
     */
    private String busiBillNo;
    /**
     * 商品序号
     */
    private Integer busiIndex;
    /**
     * 商品编码
     */
    private String skuCode;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 品牌编号
     */
    private String skuBrandCode;
    /**
     * 品牌名称
     */
    private String skuBrandName;
    /**
     * 生产厂家名称
     */
    private String productFactory;
    /**
     * 规格
     */
    private String skuFormat;
    /**
     * 商品单位
     */
    private String skuUnitName;
    /**
     * 商品型号
     */
    private String skuModel;
    /**
     * 商品单位转换率
     */
    private Integer skuUnitConvert;
    /**
     * 商品分类
     */
    private String skuCategoryno;
    /**
     * 商品出库单价
     */
    private BigDecimal skuOutPrice;
    /**
     * 出库数量
     */
    private BigDecimal outStoreQty;
    /**
     * 出库金额
     */
    private BigDecimal outStoreAmt;
    /**
     * 备注
     */
    private String remarkInfo;

    /**
     * 商品图片
     */
    private String productPicture;

}
