package com.csj.framework.mall.entity.selfsupport;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
/**
 * 物流信息
 */
public class SsDeliveryInfo extends BaseEntity {

    /**
     * 快递单号
     */
    private String logisticsOrderCode;

    /**
     * 物流名称
     */
    private String logisticsComName;

    /**
     * 出库单号
     */
    private String outOrderCode;

    /**
     * 状态
     */
    private String state;

    /**
     * 节点信息
     */
    private List<NodeInfo> routeItemVOS;

    @Data
    public class NodeInfo {

        private String remarkInfo;

        private Date eventTime;
    }


}
