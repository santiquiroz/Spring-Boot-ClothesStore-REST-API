package com.santiquiroz.restapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Getter @Setter @Column(name = "id")
    private String id;
    @Getter @Setter @Column(name = "p_description")
    private String p_description;
    @Getter @Setter @Column(name = "number_of_searches")
    private Integer number_of_searches;
    @Getter @Setter @Column(name = "images")
    private String images;

    public Product(){

    }

    public Product(String id, String p_description, Integer number_of_searches, String images) {
        this.id = id;
        this.p_description = p_description;
        this.number_of_searches = number_of_searches;
        this.images = images;
    }
}
