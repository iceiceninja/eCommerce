/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.eCommerceWebsite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iceiceninja
 */
//public record Product(long id, String name, double price) { }
public class Product {

    private long id;
    private String name;
    private double price;
    private String description;

    public Product() {
//        this.setId();
    }

    public Product(String productInfo) {
        String[] parts = productInfo.split(",");
        // Assuming you have setters for each field
        this.setId(Long.parseLong(parts[0]));
        this.setName(parts[1]);
        this.setPrice(Double.parseDouble(parts[2]));
        this.setDescription(parts[3]);
    }

    public static Product fromString(String productInfo) {
        return new Product(productInfo);
    }

    @Override
    public String toString() {
        // Return a string representation of the product, for example, comma-separated
        return getId() + "," + getName() + "," + getPrice() + "," + getDescription(); // Add more fields as needed
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void generateId() {
        Path idFilePath = Path.of("productId.txt");
        try {
            if (!Files.exists(idFilePath)) {
                Files.write(idFilePath, "1".getBytes(), StandardOpenOption.CREATE);
            }

            String currentId = Files.readString(idFilePath).trim();
            Long nextId = Long.parseLong(currentId) + 1;

            Files.write(idFilePath, nextId.toString().getBytes(), StandardOpenOption.TRUNCATE_EXISTING);

            this.id = nextId;
        } catch (IOException e) {
            throw new RuntimeException("Error generating ID: " + e.getMessage(), e);
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
