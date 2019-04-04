package com.csj.framework.common.response.data;

import com.csj.framework.mall.entity.selfsupport.SsSaleOrder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SaleOrderInfo {

    private int total;

    private int currentPage;

    private BigDecimal amount;

    private BigDecimal quantity;

    private List<SsSaleOrder> data;

}
