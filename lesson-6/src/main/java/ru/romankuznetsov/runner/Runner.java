package ru.romankuznetsov.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.romankuznetsov.entity.Product;
import ru.romankuznetsov.service.EntityDao;
import ru.romankuznetsov.service.ProductDao;

import java.util.List;

@Service
public class Runner implements CommandLineRunner {

    private final EntityDao<Product> productDao;

    public Runner(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void run(String... args) throws Exception {
        productDao.findByID(11L).ifPresent(System.out::println);
        productDao.deleteByID(101L);
        List<Product> list = productDao.findAll();
        list.forEach(System.out::println);

    }
}
