package com.fangminx.service.impl;

import com.fangminx.dto.OrderDTO;
import com.fangminx.service.OrderService;
import com.fangminx.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService  productService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //查询商品 数量，价格
        //TODO

        //计算总价

        //写入订单数据库，orderMaster和orderDetail

        //扣库存

        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
