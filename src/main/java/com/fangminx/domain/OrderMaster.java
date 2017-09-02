package com.fangminx.domain;

import com.fangminx.enums.OrderStatusEnum;
import com.fangminx.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName; //买家名字

    private String buyerPhone;  //买家电话

    private String buyerAddress; //买家地址

    private String buyerOpenid; //买家微信openid

    private BigDecimal orderAmount; //订单总金额

    private Integer orderStatus= OrderStatusEnum.NEW.getCode(); //订单状态, 默认为新下单0

    private Integer payStatus= PayStatusEnum.WAIT.getCode(); //支付状态, 默认未支付0

    private Date createTime;

    private Date updateTime;
}
