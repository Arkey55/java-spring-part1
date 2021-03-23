package ru.romankuznetsov.service;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.romankuznetsov.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDao implements EntityDao<Person> {

    private EntityManagerFactory factory;
    private EntityManager em;

    public PersonDao() {
        this.factory = new Configuration().configure("hibernate.xml")
                .buildSessionFactory();
        this.em = factory.createEntityManager();
    }

    public Optional<Person> findByID(long id){
        return Optional.ofNullable(em.find(Person.class, id));
    }

    public List<Person> findAll(){
        Query query = em.createQuery("select p from Person p");
        return query.getResultList();
    }

    public void deleteByID(long id){
        Optional <Person> product = findByID(id);
        if (product.isPresent()){
            em.getTransaction().begin();
            em.remove(product.get());
            em.getTransaction().commit();
            System.out.printf("%s - deleted successfully \n", product.get().toString());
        }
    }

    @Override
    public void saveOrUpdate(Person person){
        EntityManager em = factory.createEntityManager();
        Optional<Person> optional = findByID(person.getId());
        if (optional.isPresent()){
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
            System.out.printf("Person [%s] updated \n", person.toString());
        } else {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            System.out.printf("Person [%s] added \n", person.toString());
        }
    }
}
