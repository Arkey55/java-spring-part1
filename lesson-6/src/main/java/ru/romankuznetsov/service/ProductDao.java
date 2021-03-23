package ru.romankuznetsov.service;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.romankuznetsov.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDao implements EntityDao<Product> {

    private EntityManagerFactory factory;
    private EntityManager em;

    public ProductDao() {
        this.factory = new Configuration().configure("hibernate.xml")
                .buildSessionFactory();
        this.em = factory.createEntityManager();
    }

    public Optional<Product> findByID(long id){
        return Optional.ofNullable(em.find(Product.class, id));
    }

    public List<Product> findAll(){
        Query query = em.createQuery("select p from Product p");
        return query.getResultList();
    }

    public void deleteByID(long id){
        Optional <Product> product = findByID(id);
        if (product.isPresent()){
            em.getTransaction().begin();
            em.remove(product.get());
            em.getTransaction().commit();
            System.out.printf("%s - deleted successfully \n", product.get().toString());
        }
    }

    @Override
    public void saveOrUpdate(Product product){
        EntityManager em = factory.createEntityManager();
        Optional <Product> optional = findByID(product.getId());
        if (optional.isPresent()){
            em.getTransaction().begin();
            em.merge(product);
            em.getTransaction().commit();
            System.out.printf("Product [%s] updated \n", product.toString());
        } else {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
            System.out.printf("Product [%s] added \n", product.toString());
        }
    }
}
