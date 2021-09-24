package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.ProductXCategory;
import com.santiquiroz.restapi.models.ProductXCountry;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProductXCountryDaoImp  implements  ProductXCountryDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<ProductXCountry> getProductXCategoryByProductId(String product_id) {
        String query = "SELECT p FROM ProductXCountry p WHERE p.product_id = (?1)";
        List<ProductXCountry> productXCountry = entityManager.createQuery(query)
                .setParameter(1,product_id)
                .getResultList();
        return productXCountry;
    }

    @Override
    public List<ProductXCountry> getProductXCategoryByCountryId(String country_id) {
        String query = "SELECT p FROM ProductXCountry p WHERE p.category_id = (?1)";
        List<ProductXCountry> productXCountry = entityManager.createQuery(query)
                .setParameter(1,country_id)
                .getResultList();
        return productXCountry;
    }

    @Override
    public ProductXCountry getProductXCountry(String product_id, String country_id) {
        String query = "SELECT p FROM ProductXCountry p WHERE p.product_id = (?1) AND p.country_id = (?2)";
        ProductXCountry productXCountry= entityManager.createQuery(query, ProductXCountry.class)
                .setParameter(1,product_id)
                .setParameter(2,country_id)
                .getSingleResult();
        return productXCountry;
    }

    @Override
    public void insert(ProductXCountry productXCountry) {
        String query = "INSERT INTO productXCountry (product_id, country_id, discount_percentage, price_after_discount) VALUES (?, ?, ?, ?)";
        entityManager.createNativeQuery(query)
                .setParameter(1,productXCountry.getProduct_id())
                .setParameter(2,productXCountry.getCountry_id())
                .setParameter(3,productXCountry.getDiscount_percentage())
                .setParameter(4,productXCountry.getPrice_after_discount())
                .executeUpdate();
    }

    @Override
    public void update(ProductXCountry productXCountry) {

    }

    @Override
    public void delete(String product_id, String country_id) {

    }
}
