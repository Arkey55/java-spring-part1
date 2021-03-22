package ru.romankuznetsov.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.romankuznetsov.service.PersonDao;

@Service
public class Runner implements CommandLineRunner {

    @Autowired
    private PersonDao personDao;

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(personDao.findByID(3L).toString());
        System.out.println("gfhfjd");
    }
}
