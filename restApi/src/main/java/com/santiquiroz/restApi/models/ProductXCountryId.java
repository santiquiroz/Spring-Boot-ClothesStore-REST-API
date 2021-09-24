package com.santiquiroz.restapi.models;

import java.io.Serializable;

public class ProductXCountryId implements Serializable {
    private String product_id;
    private String country_id;

    public ProductXCountryId(){

    }

    public ProductXCountryId(String product,String country){
        this.product_id = product;
        this.country_id = country;
    }

}
