package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.Country;
import com.santiquiroz.restapi.models.Product;

public interface CountryDao {
    public Country getCountry(String id);
    public void insert(Country country);
    public void update(Country country);
    public void delete(String id);
}
