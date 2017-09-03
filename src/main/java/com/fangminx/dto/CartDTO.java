package com.fangminx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDTO {

    //商品id
    private String productId;

    //商品数量
    private Integer productQuantity;
}
