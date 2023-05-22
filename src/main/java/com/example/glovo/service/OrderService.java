package com.example.glovo.service;

import com.example.glovo.model.Order;
import com.example.glovo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    public OrderService() {
        Product teysty = Product.builder()
                .cost(2)
                .name("teysty")
                .id(1308)
                .build();

        orders.add(Order.builder()
                .cost(3)
                .date("22.05.2023")
                .id(43245)
                .products(List.of(teysty))
                .build());
    }

    public Order get(long id){
        for (Order order : orders) {
            if (order.getId()==id){
                return order;
            }
        }
        return null;
    }

    public  List<Order> getOrders(){
        return orders;
    }

    public void add(Order order){
        orders.add(order);
    }



}
