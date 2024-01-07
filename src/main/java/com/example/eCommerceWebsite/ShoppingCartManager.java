/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.eCommerceWebsite;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author iceiceninja
 */
@Component
@SessionScope
public class ShoppingCartManager {

    private ShoppingCart cart = new ShoppingCart();

    public ShoppingCart getCart() {
        return cart;
    }
}
