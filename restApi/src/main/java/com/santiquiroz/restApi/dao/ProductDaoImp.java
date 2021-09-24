package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class ProductDaoImp implements ProductDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getMostSearched(Integer amount) {
        String query = "SELECT p FROM Product p ORDER BY p.number_of_searches DESC";
        List<Product> mostSearchedProducts = entityManager.createQuery(query).setMaxResults(amount).getResultList();
        return mostSearchedProducts;
    }

    @Override
    public Product getProduct(String id) {
        String query = "SELECT p FROM Product p WHERE p.id = (?1)";
        Product product = entityManager.createQuery(query, Product.class)
                .setParameter(1,id)
                .getSingleResult();
        return product;
    }

    @Override
    public void insert(Product product) {
        String query = "INSERT INTO product (id, p_description, number_of_searches, images) VALUES (?, ?, ?, ?)";
        entityManager.createNativeQuery(query).setParameter(1,product.getId())
                .setParameter(2,product.getP_description())
                .setParameter(3,product.getNumber_of_searches())
                .setParameter(4,product.getImages())
                .executeUpdate();
    }

    @Override
    public void update(Product newProductData) {

        entityManager.merge(newProductData);
    }

    @Override
    public void delete(String id) {
        Product product = getProduct(id);
        entityManager.remove(product);
    }
}
