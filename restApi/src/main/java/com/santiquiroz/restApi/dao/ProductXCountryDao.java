package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.Product;
import com.santiquiroz.restapi.models.ProductXCountry;

import java.util.List;

public interface ProductXCountryDao {
    public List<ProductXCountry> getProductXCategoryByProductId(String product_id);
    public List<ProductXCountry> getProductXCategoryByCountryId(String country_id);
    public ProductXCountry getProductXCountry(String product_id,String country_id);
    public void insert(ProductXCountry productXCountry);
    public void update(ProductXCountry productXCountry);
    public void delete(String product_id,String country_id);
}
