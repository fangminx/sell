package com.fangminx.dto;

import com.fangminx.Util.serializer.Date2LongSerializer;
import com.fangminx.domain.OrderDetail;
import com.fangminx.enums.OrderStatusEnum;
import com.fangminx.enums.PayStatusEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    private String orderId;

    private String buyerName; //买家名字

    private String buyerPhone;  //买家电话

    private String buyerAddress; //买家地址

    private String buyerOpenid; //买家微信openid

    private BigDecimal orderAmount; //订单总金额

    private Integer orderStatus; //订单状态, 默认为新下单0

    private Integer payStatus; //支付状态, 默认未支付0

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
