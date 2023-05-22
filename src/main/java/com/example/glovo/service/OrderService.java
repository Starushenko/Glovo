package com.example.glovo.service;

import com.example.glovo.model.Order;
import com.example.glovo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order get(int id){
       return orderRepository.findById(id).orElseThrow();
    }

    public  List<Order> getOrders(){
        return orderRepository.findAll();
    }


    public Order create(Order order){
        return orderRepository.save(order);
    }

    public void delete(int id){
        orderRepository.deleteById(id);
    }

//    public Order update(int id){
//        return orderRepository.update(id);
//    }

}
