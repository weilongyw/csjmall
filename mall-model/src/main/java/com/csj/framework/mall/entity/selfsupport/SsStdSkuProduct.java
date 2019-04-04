package com.csj.framework.mall.entity.selfsupport;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

@Data
public class SsStdSkuProduct extends BaseEntity {

    private String id;
    /**
     * sku商品编码
     */
    private String productNo;
    /**
     * 标准商品编码
     */
    private String stdProductNo;
    /**
     * sku图片-pictureUrl
     */
    private String pictureUrl;
    /**
     * 西域sku-skuCode
     */
    private String skuCode;
    /**
     * 型号-mfgSku
     */
    private String size;
    /**
     * 规格属性名称
     */
    private String ruleName;
    /**
     * 销售价-salePrice
     */
    private String salePrice;
    /**
     * 库存
     */
    private String stock;
    /**
     * 参考价
     */
    private String referencePrice;
    /**
     * 条形码
     */
    private String barCode;
    /**
     * 商品货号
     */
    private String goodsNo;
    /**
     * 商品标题-productName
     */
    private String skuTitle;

    /**
     * 一级类目编号
     */
    private String lv1CategoryNo;

    /**
     * 二级类目编号
     */
    private String lv2CategoryNo;
    /**
     * 三级类目编号
     */
    private String lv3CategoryNo;
    /**
     * 一级类目名称
     */
    private String lv1CategoryName;
    /**
     * 二级类目名称
     */
    private String lv2CategoryName;
    /**
     * 三级类目名称
     */
    private String lv3CategoryName;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 品牌ID
     */
    private String brandId;
    /**
     * 商品单位
     */
    private String minUnit;
    //
    /**
     * 商品详情
     */
    private String productInfo;

    /**
     * 商品是否可用
     */
    private String isUsed;
    /**
     * "packJson":[
     * {
     * "packKey" : "weight",
     * "packValue" : "重量(kg)"
     * },
     * {
     * "packKey" : "height",
     * "packValue" : "高度(mm)"
     * },
     * {
     * "packKey" : "width",
     * "packValue" : "宽度(mm)"
     * },
     * {
     * "packKey" : "length",
     * "packValue" : "长度(mm)"
     * }
     * ]
     */
    private JSONArray packJson;
    /**
     * "basicAttr" : [
     * {
     * "id":"id",
     * "basicKey" : "基础属性key-specParam[].paramName",
     * "basicValue" : "基础属性value-specParam[].paramValue"
     * }
     * ]
     */
    private JSONArray basicAttr;
    /**
     * [
     * {
     * "id":"",
     * "saleKey":"销售属性key-attrGroup[].attrName",
     * "saleValue":"销售属性value-attrGroup[].attrValue"
     * }
     * ]
     */
    private JSONArray saleAttr;
    /**
     * [
     * {
     * "levelName":"客户等级",
     * "salePrice":"销售价格（元）"
     * }
     * ]
     */
    private JSONArray saleStrategy;
    /**
     * {num:**,unit:箱}
     */
    private JSONObject unitConvert;


    //其他相同型号的商品
    private List<SsStdSkuProduct> stdSkuProducts;

}
