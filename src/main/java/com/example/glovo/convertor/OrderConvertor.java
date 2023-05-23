package com.example.glovo.convertor;

import com.example.glovo.model.Order;
import com.example.glovo.entity.OrderEntity;

public class OrderConvertor {
    public static Order orderEntityToOrder(OrderEntity orderEntity){
        return Order.builder()
                .id(orderEntity.getId())
                .date(orderEntity.getDate())
                .cost(orderEntity.getCost())
                .build();
    }

    public static OrderEntity orderToEntityOrder(Order order){
        return OrderEntity.builder()
                .id(order.getId())
                .date(order.getDate())
                .cost(order.getCost())
                .build();
    }
}
