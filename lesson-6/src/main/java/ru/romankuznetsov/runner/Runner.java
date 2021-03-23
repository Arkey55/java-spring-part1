package ru.romankuznetsov.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.romankuznetsov.entity.Person;
import ru.romankuznetsov.entity.Product;
import ru.romankuznetsov.service.EntityDao;

import java.util.List;

@Service
public class Runner implements CommandLineRunner {

    private final EntityDao<Product> productDao;
    private final EntityDao<Person> personDao;

    public Runner(EntityDao<Product> productDao,
                  EntityDao<Person> personDao
    ) {
        this.productDao = productDao;
        this.personDao = personDao;
    }

    @Override
    public void run(String... args) throws Exception {
//        productDao.findByID(11L).ifPresent(System.out::println);
//        productDao.deleteByID(101L);

//        Product product = new Product();
//        product.setId(100L);
//        product.setTitle("Toy-45");
//        product.setPrice(3415);
//        productDao.saveOrUpdate(product);

        List<Product> productList = productDao.findAll();
        productList.forEach(System.out::println);

        List<Person> personList = personDao.findAll();
        personList.forEach(System.out::println);

    }
}
