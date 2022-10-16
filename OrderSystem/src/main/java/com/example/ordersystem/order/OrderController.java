package com.example.ordersystem.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/orders/new")
    public String showNewForm(Model model){
        model.addAttribute("order",new Order());
        return "order_form";
    }

    @PostMapping("/orders/save")
    public String saveOrder(Order order, RedirectAttributes ra){
        service.save(order);
        ra.addFlashAttribute("message", "The order has been added successfully.");

        return "redirect:/orders";
    }

}
