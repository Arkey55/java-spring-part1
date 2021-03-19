package ru.romankuznetsov.service;

import org.hibernate.cfg.Configuration;
import ru.romankuznetsov.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class ProductDao {
    private EntityManagerFactory factory = new Configuration()
            .configure("hibernate.xml")
            .buildSessionFactory();

    public Optional<Product> findByID(long id){
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("select p from Product p where p.id = :id");
        query.setParameter("id", id);
        Product product = null;
        try {
            product = (Product) query.getSingleResult();
        } catch (NoResultException e){
            System.out.println("No such product in the db...");
        }
        return Optional.ofNullable(product);
    }

    public List<Product> findAll(){
        EntityManager em = factory.createEntityManager();
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    public void deleteByID(long id){
        EntityManager em = factory.createEntityManager();
        Optional <Product> product = findByID(id);
        if (product.isPresent()){
            em.getTransaction().begin();
            Query query = em.createQuery("delete from Product p where p.id = :id");
            query.setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
            System.out.printf("%s - deleted successfully \n", product.toString());
        }
    }

    public void saveOrUpdate(Product product){
        EntityManager em = factory.createEntityManager();
        Optional <Product> optional = findByID(product.getId());
        if (optional.isPresent()){
            em.getTransaction().begin();
            Query query = em.createQuery("update Product p set p.title = :title, p.price = :price where p.id = :id");
            query.setParameter("title", product.getTitle());
            query.setParameter("price", product.getPrice());
            query.setParameter("id", product.getId());
            query.executeUpdate();
            em.getTransaction().commit();
            System.out.printf("Product [%s] updated \n", product.toString());
        } else {
            em.getTransaction().begin();
            Query query = em.createNativeQuery("insert into product (id, title, price) values (:id, :title, :price)");
            query.setParameter("title", product.getTitle());
            query.setParameter("price", product.getPrice());
            query.setParameter("id", product.getId());
            query.executeUpdate();
            em.getTransaction().commit();
            System.out.printf("Product [%s] added \n", product.toString());
        }
    }
}
