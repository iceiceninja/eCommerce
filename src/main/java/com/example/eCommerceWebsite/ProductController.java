package com.example.eCommerceWebsite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author iceiceninja
 */
@Controller
public class ProductController {
    ProductService productService = new ProductService();

    @GetMapping("/add-product")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProductsForm";
    }
    
    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product, Model model)
    {
        try {
            productService.AddProduct(product);
        } catch (IOException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Product> productList = productService.GetAllProducts();//.add(product);
        model.addAttribute("productList", productList);
        return "productsList";
    }
    
    @GetMapping("/products")
    public String showAllProducts(Model model) {
        List<Product> productList = productService.GetAllProducts();//.add(product);
        model.addAttribute("productList", productList);
        for(Product product : productList)
        {
            System.out.println(product.toString());
        }
        return "productsList";
    }
}
