/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.eCommerceWebsite;

/**
 *
 * @author iceiceninja
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    ProductService productService = new ProductService();

    @GetMapping("/home")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        List<Product> productList = productService.GetAllProducts();//.add(product);
        productList = productList.subList(0, Math.min(productList.size(), 3));
        model.addAttribute("products", productList);
        return "home";
    }
}
