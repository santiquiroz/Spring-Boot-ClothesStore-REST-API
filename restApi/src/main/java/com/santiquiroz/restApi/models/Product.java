package com.santiquiroz.restapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Getter @Setter @Column(name = "id")
    private Integer id;
    @Getter @Setter @Column(name = "p_description")
    private String p_description;
    @Getter @Setter @Column(name = "number_of_searches")
    private Integer number_of_searches;
    @Getter @Setter @Column(name = "images")
    private String[] images;


}
