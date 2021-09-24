package com.santiquiroz.restapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "productxcategory")
@IdClass(ProductXCategoryId.class)
public class ProductXCategory implements Serializable {

    @Id
    @Getter @Setter @Column(name = "product_id")
    private String product_id;
    @Id
    @Getter @Setter @Column(name = "category_id")
    private String category_id;

    public ProductXCategory(){

    }

    public ProductXCategory(String product_id, String category_id){
        setProduct_id(product_id);
        setCategory_id(category_id);
    }

}
