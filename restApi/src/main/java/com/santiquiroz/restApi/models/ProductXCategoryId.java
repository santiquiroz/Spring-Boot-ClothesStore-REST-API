package com.santiquiroz.restapi.models;

import java.io.Serializable;

public class ProductXCategoryId implements Serializable {
    private String product_id;
    private String category_id;


    public ProductXCategoryId(String product,String category){
        this.product_id = product;
        this.category_id = category;
    }
}
