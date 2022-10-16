package com.example.ordersystem.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Order get(Integer id) throws OrderNotFoundException {
        Optional<Order> result=repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }

        throw new OrderNotFoundException("could not find orders with ID:"+id);
    }

    public void delete(Integer id) throws OrderNotFoundException {

        Optional<Order> result=repo.findById(id);
        if(result.isPresent()){
            throw new OrderNotFoundException("could not find orders with ID:"+id);
        }
        repo.deleteById(id);
    }
}
