package ru.romankuznetsov.service;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.romankuznetsov.entity.Person;
import ru.romankuznetsov.entityManager.MyEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class PersonDao implements EntityDao<Person> {
    private EntityManagerFactory factory = new Configuration()
            .configure("hibernate.xml")
            .buildSessionFactory();
    EntityManager em1 = factory.createEntityManager();

    private MyEntityManager em = new MyEntityManager();

    @Override
    public Optional<Person> findByID(long id) {
        return Optional.ofNullable(em1.find(Person.class, id));
    }

    @Override
    public List<Person> findAll() {
        Query query = em.createEm().createQuery("select p from Person p");
        return query.getResultList();
    }

    @Override
    public void deleteByID(long id) {
        Person person = em.createEm().find(Person.class, id);
        em.createEm().getTransaction().begin();
        em.createEm().remove(person);
        em.createEm().getTransaction().commit();
    }

    @Override
    public void save(Person person) {

    }

    @Override
    public void update(Person person, String[] params) {

    }
}
