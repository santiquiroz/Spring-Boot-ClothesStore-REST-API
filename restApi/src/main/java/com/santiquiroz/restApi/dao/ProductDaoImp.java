package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class ProductDaoImp implements  ProductDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getMostSearched() {
        String query = "FROM Product";
        List<Product> mostSearchedProducts = entityManager.createQuery(query).getResultList();
        return mostSearchedProducts;
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update() {

    }
}
