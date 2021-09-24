package com.santiquiroz.restapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "productxcountry")
@IdClass(ProductXCountryId.class)
public class ProductXCountry {

    @Id
    @Getter @Setter @Column(name = "product_id")
    private String product_id;
    @Id
    @Getter @Setter @Column(name = "country_id")
    private String country_id;

    @Getter @Setter @Column(name = "price")
    private Float price;

    @Getter @Setter @Column(name = "discount_percentage")
    private Float discount_percentage;

    @Getter @Setter @Column(name = "price_after_discount")
    private Float price_after_discount;

    public ProductXCountry() {

    }

    public  ProductXCountry(String product_id, String country_id, Float discount_percentage, Float price_after_discount) {
        setProduct_id(product_id);
        setCountry_id(country_id);
        this.discount_percentage =  discount_percentage;
        this.price_after_discount=price_after_discount;
    }
}
