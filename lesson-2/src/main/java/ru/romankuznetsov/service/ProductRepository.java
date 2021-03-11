package ru.romankuznetsov.service;

import org.springframework.stereotype.Component;
import ru.romankuznetsov.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    private List<Product> getProducts() {
        return products;
    }

    public void showProductsInRepo(){
        if (products.size() > 0){
            products.forEach(System.out::println);
        } else {
            System.out.println("Sorry, no products available");
        }
    }

    public Product getProductByID(int id){
        for (Product p : getProducts()){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void formRepository(){
        products.add(new Product(1, "p1", 10));
        products.add(new Product(2, "p2", 7));
        products.add(new Product(3, "p3", 13));
        products.add(new Product(4, "p4", 20));
        products.add(new Product(5, "p5", 4));
    }

}
