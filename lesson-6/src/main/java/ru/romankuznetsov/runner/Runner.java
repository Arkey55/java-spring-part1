package ru.romankuznetsov.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.romankuznetsov.entity.Person;
import ru.romankuznetsov.entity.Product;
import ru.romankuznetsov.service.DBManager;
import ru.romankuznetsov.service.EntityDao;

import java.util.List;

@Service
public class Runner implements CommandLineRunner {

    private final EntityDao<Product> productDao;
    private final EntityDao<Person> personDao;
    private final DBManager manager;

    public Runner(EntityDao<Product> productDao,
                  EntityDao<Person> personDao,
                  DBManager manager) {
        this.productDao = productDao;
        this.personDao = personDao;
        this.manager = manager;
    }

    @Override
    public void run(String... args) throws Exception {
        List list1 = manager.findProductsByPersonId(4L);
        list1.forEach(System.out::println);
        List list2 = manager.findPersonsByProductId(5L);
        list2.forEach(System.out::println);
    }
}
