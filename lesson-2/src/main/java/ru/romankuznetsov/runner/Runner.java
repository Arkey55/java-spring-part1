package ru.romankuznetsov.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.romankuznetsov.entity.Cart;
import ru.romankuznetsov.entity.Product;
import ru.romankuznetsov.entity.ProductRepository;


@Service
public class Runner implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Cart cart;



    @Override
    public void run(String... args) throws Exception {
        cart.addAllProducts();
        for (Product p : productRepository.getProducts()){
            System.out.println(p.toString());
        }
    }

}