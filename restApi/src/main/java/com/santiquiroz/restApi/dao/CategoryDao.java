package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.Category;
import com.santiquiroz.restapi.models.Product;

public interface CategoryDao{
    public Category getCategory(String id);
    public void insert(Category category);
    public void update(Category category);
    public void delete(String id);
}
