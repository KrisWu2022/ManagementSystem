package com.example.ordersystem.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/orders")
    public String showOrderList(Model model){
        List<Order> listOrders=service.listAll();
        model.addAttribute("listOrders",listOrders);

        return "orders";
    }

}
