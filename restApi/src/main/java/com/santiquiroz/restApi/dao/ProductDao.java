package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> getMostSearched();
    public void insert(Product product);
    public void update();

}
