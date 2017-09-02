package com.fangminx.domain;

import com.fangminx.enums.ProductStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@DynamicUpdate
@Entity
public class ProductInfo {

    @Id
    private String productId;

    private String productName; //商品名称

    private BigDecimal productPrice; //单价

    private Integer productStock;   //库存

    private String productDescription;  //描述

    private String productIcon; //小图

    private Integer productStatus= ProductStatusEnum.up.getCode();  //商品状态,0正常(default)1下架

    private Integer categoryType;   //类目编号

    private Date createTime;

    private Date updateTime;
}
