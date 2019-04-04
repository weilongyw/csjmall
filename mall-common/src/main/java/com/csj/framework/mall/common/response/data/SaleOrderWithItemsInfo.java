package com.csj.framework.mall.common.response.data;

import com.csj.framework.mall.entity.selfsupport.SsSaleOrder;
import com.csj.framework.mall.entity.selfsupport.SsSaleOrderItem;
import lombok.Data;

import java.util.List;

@Data
public class SaleOrderWithItemsInfo {

    private SsSaleOrder saleOrder;

    private List<SsSaleOrderItem> saleOrderItems;

    private String outNoticeFlag;

    private String fromsystem;

}
