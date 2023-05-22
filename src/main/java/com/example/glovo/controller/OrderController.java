package com.example.glovo.controller;

import com.example.glovo.model.Order;
import com.example.glovo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAll(){
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable int id){
        return orderService.get(id);
    }

    @PostMapping
    public Order create(@RequestBody Order order){
       return orderService.create(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        orderService.delete(id);
    }
}
