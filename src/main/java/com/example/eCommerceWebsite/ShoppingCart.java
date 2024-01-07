/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.eCommerceWebsite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iceiceninja
 */
public class ShoppingCart {
    private List<Product> cartItems = new ArrayList<>();

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void addToCart(Product product) {
        cartItems.add(product);
    }

    public void removeFromCart(Product product) {
        cartItems.remove(product);
    }

    public void clearCart() {
        cartItems.clear();
    }
}

