/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.eCommerceWebsite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author iceiceninja
 */
@Service
public class ProductService {

    private Path filePathObj;

    //NOT A REAL SERVICE (i dont think it is anyway) Eventually set up a repository
    public ProductService() {
        filePathObj = Path.of("productFile.txt");
        if (!Files.exists(filePathObj)) {
            try {
                Files.createFile(filePathObj);
                System.out.println("File Created");
            } catch (IOException ex) {
                System.out.println("Error Creating File");
                Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("File Found");
        }
    }

    public List<Product> GetAllProducts() {
        List<Product> productList = new ArrayList<>();
        try {
            // Read all lines from the file, convert to Product objects, and add to the list
            productList = Files.lines(filePathObj)
                    .map(Product::fromString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        return productList;
    }

    public void AddProduct(Product product) throws IOException {
        product.generateId();
        String productInfo = product.toString();
        Files.write(filePathObj, Collections.singletonList(productInfo), StandardOpenOption.APPEND);
    }

    public Product GetProductById(long id) {
        try {
            Product product = (Product) Files.lines(filePathObj)
                    .map(Product::fromString)
                    .filter(prdct -> prdct.getId() == id)
                    .findFirst()
                    .orElse(null);
            return product;

        } catch (IOException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
