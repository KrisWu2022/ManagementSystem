package com.example.ordersystem.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public List<Order> listAll(){
        return (List<Order>) repo.findAll();
    }

    public void save(Order order) {
        repo.save(order);
    }
}
