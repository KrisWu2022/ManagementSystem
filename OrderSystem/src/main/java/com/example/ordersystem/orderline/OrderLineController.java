package com.example.ordersystem.orderline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OrderLineController {

    @Autowired
    private OrderLineService service;

    @GetMapping("/orderlines")
    public String showOrderLineList(Model model){
        List<OrderLine> listOrderLines=service.listAll();
        model.addAttribute("listOrderLines",listOrderLines);

        return "orderLines";
    }

    @GetMapping("/orderlines/new")
    public String showNewForm(Model model){
        model.addAttribute("orderLine",new OrderLine());
        return "orderline_form";
    }

    @PostMapping("/orderlines/save")
    public String saveOrderLine(OrderLine orderLine, RedirectAttributes ra){
        service.save(orderLine);
        ra.addFlashAttribute("message", "The orderline has been added successfully.");

        return "redirect:/orderlines";
    }

}
