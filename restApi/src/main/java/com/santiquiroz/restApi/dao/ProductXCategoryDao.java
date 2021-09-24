package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.ProductXCategory;

import java.util.List;

public interface ProductXCategoryDao {
    public List<ProductXCategory> getAll();
    public List<ProductXCategory> getProductXCategoryByProductId(String product_id);
    public List<ProductXCategory> getProductXCategoryByCategoryId(String category_id);
    public ProductXCategory getProductXCategory(String product_id, String category_id);
    public void insert(ProductXCategory productXCategory);
    public void update(ProductXCategory productXCategory);
    public void delete(String product_id, String category_id);
}
