package com.example.ordersystem.orderline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {

    @Autowired
    private OrderLineRepository repo;

    public List<OrderLine> listAll(){
        return (List<OrderLine>) repo.findAll();
    }

    public void save(OrderLine orderLine) {
        repo.save(orderLine);
    }

}
