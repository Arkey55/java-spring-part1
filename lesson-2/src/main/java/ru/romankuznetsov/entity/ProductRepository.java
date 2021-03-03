package ru.romankuznetsov.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public void addToList(Product product){
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
