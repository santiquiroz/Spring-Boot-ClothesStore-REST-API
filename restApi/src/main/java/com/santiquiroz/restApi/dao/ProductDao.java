package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> getMostSearched(Integer amount);
    public Product getProduct(String id);
    public void insert(Product product);
    public void update(Product product);
    public void delete(String id);

}
