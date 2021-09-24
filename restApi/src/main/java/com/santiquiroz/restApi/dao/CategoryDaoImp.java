package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.Category;
import com.santiquiroz.restapi.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CategoryDaoImp implements CategoryDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Category getCategory(String id) {
        String query = "SELECT c FROM Category c WHERE c.id = (?1)";
        Category category = entityManager.createQuery(query, Category.class)
                .setParameter(1,id)
                .getSingleResult();
        return category;
    }

    @Override
    public void insert(Category category) {
        String query = "INSERT INTO category (id) VALUES (?)";
        entityManager.createNativeQuery(query).setParameter(1,category.getId())
                .executeUpdate();
    }

    @Override
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Override
    public void delete(String id) {
        Category category = getCategory(id);
        entityManager.remove(category);
    }
}
