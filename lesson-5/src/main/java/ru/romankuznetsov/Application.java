package ru.romankuznetsov;

import org.hibernate.cfg.Configuration;
import ru.romankuznetsov.entity.Person;
import ru.romankuznetsov.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.xml")
                .buildSessionFactory();
        EntityManager em = factory.createEntityManager();
        // Save in BD
//        Person tarasBulba = new Person("Taras", "Bulba");
//        em.getTransaction().begin();
//        em.persist(tarasBulba);
//        em.getTransaction().commit();

        // Search entity in BD by PK
//        Person person1 = em.find(Person.class, 4L);
//        System.out.println(person1.toString());

        // Update entity in BD
//        em.getTransaction().begin();
//        person1.setFirstName("Anna");
//        em.merge(person1);
//        em.getTransaction().commit();
//        System.out.println(person1.toString());



//        Person person = (Person) em.createQuery("select p from Person p where id=4L").getSingleResult();
//        System.out.println(person.toString());
//
//        List<Person> personList = (List<Person>) em.createQuery("select p from Person p").getResultList();
//        personList.forEach(p -> System.out.println(p.toString()));

//        Query query = em.createQuery("select p from Person p where p.firstName like :name");
//        query.setParameter("name", "Tar%");
//        Person person1;
//        try{
//            person1 = (Person) query.getSingleResult();
//            System.out.println(person1.toString());
//        } catch (NoResultException e){
//            System.out.println("No such person in db...");
//        }

//        em.createNamedQuery("Person.findAll", Person.class)
//                .getResultList()
//                .forEach(p -> System.out.println(p.toString()));
//
//        em.createNamedQuery("Person.findAllNames", String.class).getResultList()
//                .forEach(System.out::println);

        ProductDao p = new ProductDao();
        Product product = new Product(7L, "Toy", 1032);
//        p.saveOrUpdate(product);
//        p.deleteByID(4L);
        p.findAll();
        p.findByID(4L).ifPresent(System.out::println);
    }
}
