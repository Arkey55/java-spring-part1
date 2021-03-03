package ru.romankuznetsov.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cart {
    @Autowired
    private ProductRepository productRepository;

    private Product p1 = new Product(1, "p1", 10);
    private Product p2 = new Product(2, "p2", 7);
    private Product p3 = new Product(3, "p3", 13);
    private Product p4 = new Product(4, "p4", 20);
    private Product p5 = new Product(5, "p5", 4);

    public void addAllProducts(){
        productRepository.addToList(p1);
        productRepository.addToList(p2);
        productRepository.addToList(p3);
        productRepository.addToList(p4);
        productRepository.addToList(p5);
    }

    public Product getProductByID(int id){
        for (Product p : productRepository.getProducts()){
            if (p.getId() == id){
                return p;
            }
        }
        System.out.println("Данный продукт не найден");
        return null;
    }

}
