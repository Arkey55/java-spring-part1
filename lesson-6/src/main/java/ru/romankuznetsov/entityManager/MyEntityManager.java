package ru.romankuznetsov.entityManager;

import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MyEntityManager {
    private EntityManagerFactory factory = new Configuration()
            .configure("hibernate.xml")
            .buildSessionFactory();

    public EntityManager createEm(){
        return factory.createEntityManager();
    }
}
