package xyz.optimized.service;

import org.openapi.example.model.Product;

public class MyService {

    public String getMessage() {
        return "Hello, World! from Service";
    }

    public Product getProduct() {
        return new Product().id("1").name("Product 1").description("Description 1");
    }
}
