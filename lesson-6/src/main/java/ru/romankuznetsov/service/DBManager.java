package ru.romankuznetsov.service;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.romankuznetsov.entity.Person;
import ru.romankuznetsov.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Component
public class DBManager {
    private EntityManagerFactory factory;
    private EntityManager em;
    private final EntityDao<Product> productDao;
    private final EntityDao<Person> personDao;

    public DBManager(EntityDao<Product> productDao,
                  EntityDao<Person> personDao
    ) {
        this.factory = new Configuration().configure("hibernate.xml")
                .buildSessionFactory();
        this.em = factory.createEntityManager();
        this.productDao = productDao;
        this.personDao = personDao;
    }

    public List findProductsByPersonId(long id){
        Query query = em.createQuery("select p from Product p left join p.persons ps where ps.id = :id", Product.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List findPersonsByProductId(long id){
        Query query = em.createQuery("select p from Person p left join p.products pr where pr.id = :id", Person.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

}
