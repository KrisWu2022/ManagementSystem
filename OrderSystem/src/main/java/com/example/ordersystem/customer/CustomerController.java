package com.example.ordersystem.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/customers")
    public String showCustomerList(Model model){
        List<Customer> listCustomers=service.listAll();
        model.addAttribute("listCustomers",listCustomers);

        return "customers";
    }

    @GetMapping("/customers/new")
    public String showNewForm(Model model){
        model.addAttribute("customer",new Customer());
        return "customer_form";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(Customer customer, RedirectAttributes ra){
        service.save(customer);
        ra.addFlashAttribute("message", "The customer has been added successfully.");

        return "redirect:/customers";
    }

}

