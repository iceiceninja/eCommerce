/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.eCommerceWebsite;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author iceiceninja
 */
@Controller
public class ShoppingCartController {

    private final ShoppingCartManager cartManager;
    private final ProductService productService;

    @Autowired
    public ShoppingCartController(ShoppingCartManager cartManager, ProductService productService) {
        this.cartManager = cartManager;
        this.productService = productService;
    }

    @PostMapping("/addToCart/{productId}")
    public String addToCart(@PathVariable Long productId) {
        // Retrieve the product based on productId (from a database or repository)
        Product product = productService.GetProductById(productId);

        // Add the product to the cart
        cartManager.getCart().addToCart(product);

        return "redirect:/shoppingCart";
    }

    @PostMapping("/removeFromCart/{productId}")
    public String removeFromCart(@PathVariable Long productId) {
        // Retrieve the product based on productId (from a database or repository)
        Product product = productService.GetProductById(productId);
        cartManager.getCart().removeFromCart(product);

        return "redirect:/shoppingCart";
    }

    @PostMapping("/clearCart")
    public String clearCart() {
        cartManager.getCart().clearCart();
        return "redirect:/shoppingCart";
    }

    @GetMapping("/shoppingCart") // Corrected the URL mapping
    public String shoppingCartView(Model model) {
        // Retrieve the products in the shopping cart
        List<Product> shoppingCart = cartManager.getCart().getCartItems();
        model.addAttribute("cartItems", shoppingCart);

        return "shoppingCart";
    }
}
