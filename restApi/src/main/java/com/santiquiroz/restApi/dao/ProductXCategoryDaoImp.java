package com.santiquiroz.restapi.dao;


import com.santiquiroz.restapi.models.Product;
import com.santiquiroz.restapi.models.ProductXCategory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProductXCategoryDaoImp implements ProductXCategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductXCategory> getAll() {
        String query = "SELECT p FROM ProductXCategory p";
        List<ProductXCategory> productXCategory = entityManager.createQuery(query).getResultList();
        return productXCategory;
    }

    @Override
    public List<ProductXCategory> getProductXCategoryByProductId(String product_id) {
        String query = "SELECT p FROM ProductXCategory p WHERE p.product_id = (?1)";
        List<ProductXCategory> productXCategory = entityManager.createQuery(query)
                .setParameter(1,product_id)
                .getResultList();
        return productXCategory;
    }

    @Override
    public List<ProductXCategory> getProductXCategoryByCategoryId(String category_id) {
        String query = "SELECT p FROM ProductXCategory p WHERE p.category_id = (?1)";
        List<ProductXCategory> productXCategory = entityManager.createQuery(query)
                .setParameter(1,category_id)
                .getResultList();
        return productXCategory;
    }

    @Override
    public ProductXCategory getProductXCategory(String product_id, String category_id) {
        String query = "SELECT p FROM ProductXCategory p WHERE p.product_id = (?1) AND p.category_id = (?2)";
        ProductXCategory productXCategory = entityManager.createQuery(query, ProductXCategory.class)
                .setParameter(1,product_id)
                .setParameter(2,category_id)
                .getSingleResult();
        return productXCategory;
    }

    @Override
    public void insert(ProductXCategory productXCategory) {
        String query = "INSERT INTO productXCategory (product_id, category_id) VALUES (?, ?)";
        System.out.println(productXCategory.getProduct_id());
        entityManager.createNativeQuery(query)
                .setParameter(1,productXCategory.getProduct_id())
                .setParameter(2,productXCategory.getCategory_id())
                .executeUpdate();
    }

    @Override
    public void update(ProductXCategory productXCategory) {
        entityManager.merge(productXCategory);
    }

    @Override
    public void delete(String product_id, String category_id) {
        ProductXCategory productXCategory = getProductXCategory(product_id,category_id);
        entityManager.remove(productXCategory);
    }
}
