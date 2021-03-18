package ru.romankuznetsov;

import org.hibernate.cfg.Configuration;
import ru.romankuznetsov.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ProductDao {
    private EntityManagerFactory factory = new Configuration()
            .configure("hibernate.xml")
            .buildSessionFactory();
    private EntityManager em = factory.createEntityManager();

    public void findByID(long id){
        Query query = em.createQuery("select p from Product p where p.id = :id");
        query.setParameter("id", id);
        Product product;
        try{
            product = (Product) query.getSingleResult();
            System.out.println(product.toString());
        } catch (NoResultException e){
            System.out.println("No such product in db...");
        }
    }

    public void findAll(){
        em.createNamedQuery("Product.findAll", Product.class).getResultList()
                .forEach(System.out::println);
    }

    public void deleteByID(long id){
        Product product = em.find(Product.class, id);
        if (product != null){
            em.getTransaction().begin();
            em.remove(product);
            System.out.printf("%s - deleted \n", product.toString());
            em.getTransaction().commit();
        } else {
            System.out.println("No such product in a db...");
        }
    }

    public void saveOrUpdate(Product product){
        Query query = em.createQuery("select p from Product p where p.id = :id");
        query.setParameter("id", product.getId());
        Product product1;
        try{
            product1 = (Product) query.getSingleResult();
            em.getTransaction().begin();
            query = em.createQuery("update Product p set p.title = :title, p.price = :price where id = :id");
            query.setParameter("id", product.getId());
            query.setParameter("title", product.getTitle());
            query.setParameter("price", product.getPrice());
            em.getTransaction().commit();
        } catch (NoResultException e){
            System.out.println("111");
        }

    }
}
