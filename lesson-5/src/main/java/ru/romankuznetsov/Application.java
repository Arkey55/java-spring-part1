package ru.romankuznetsov;

import ru.romankuznetsov.entity.Product;
import ru.romankuznetsov.service.ProductDao;

public class Application {
    public static void main(String[] args) {
        ProductDao p = new ProductDao();
        Product product = new Product();
        product.setId(99L);
        product.setTitle("Toy-33");
        product.setPrice(1345);
//        p.saveOrUpdate(product);

//        p.deleteByID(3L);
        p.findAll().forEach(System.out::println);
        p.findByID(10L).ifPresent(System.out::println);
    }
}
