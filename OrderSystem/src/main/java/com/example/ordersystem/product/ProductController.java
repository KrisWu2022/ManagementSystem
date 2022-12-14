package com.example.ordersystem.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public String showProductList(Model model){
        List<Product> listProducts=service.listAll();
        model.addAttribute("listProducts",listProducts);

        return "products";
    }

    @GetMapping("/products/new")
    public String showNewForm(Model model){
        model.addAttribute("product",new Product());
        return "product_form";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product, RedirectAttributes ra){
        service.save(product);
        ra.addFlashAttribute("message", "The product has been added successfully.");

        return "redirect:/products";
    }

}

