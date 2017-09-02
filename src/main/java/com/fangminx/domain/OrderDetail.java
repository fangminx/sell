package com.fangminx.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName; //商品名称
    
    private BigDecimal productPrice; //当前价格,单位分

    private Integer productQuantity; //数量

    private String productIcon; //小图

    private Date createTime;

    private Date updateTime;
}
