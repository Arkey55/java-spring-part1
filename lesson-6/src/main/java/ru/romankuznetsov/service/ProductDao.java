package ru.romankuznetsov.service;

import ru.romankuznetsov.entity.Product;
import ru.romankuznetsov.entityManager.MyEntityManager;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class ProductDao {
    private MyEntityManager em;

    public Optional<Product> findByID(long id){
        em = new MyEntityManager();
        Query query = em.createEm().createQuery("select p from Product p where p.id = :id");
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
        em = new MyEntityManager();
        return em.createEm().createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    public void deleteByID(long id){
        em = new MyEntityManager();
        Optional <Product> product = findByID(id);
        if (product.isPresent()){
            em.createEm().getTransaction().begin();
            Query query = em.createEm().createQuery("delete from Product p where p.id = :id");
            query.setParameter("id", id).executeUpdate();
            em.createEm().getTransaction().commit();
            System.out.printf("%s - deleted successfully \n", product.toString());
        }
    }

    public void saveOrUpdate(Product product){
        em = new MyEntityManager();
        Optional <Product> optional = findByID(product.getId());
        if (optional.isPresent()){
            em.createEm().getTransaction().begin();
            Query query = em.createEm().createQuery("update Product p set p.title = :title, p.price = :price where p.id = :id");
            query.setParameter("title", product.getTitle());
            query.setParameter("price", product.getPrice());
            query.setParameter("id", product.getId());
            query.executeUpdate();
            em.createEm().getTransaction().commit();
            System.out.printf("Product [%s] updated \n", product.toString());
        } else {
            em.createEm().getTransaction().begin();
            Query query = em.createEm().createNativeQuery("insert into product (id, title, price) values (:id, :title, :price)");
            query.setParameter("title", product.getTitle());
            query.setParameter("price", product.getPrice());
            query.setParameter("id", product.getId());
            query.executeUpdate();
            em.createEm().getTransaction().commit();
            System.out.printf("Product [%s] added \n", product.toString());
        }
    }
}
