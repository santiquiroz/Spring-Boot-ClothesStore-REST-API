package com.santiquiroz.restapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Setter @Getter
    private String id;
    @Setter @Getter
    private Float maximum_discount_percentage;
    @Setter @Getter
    private String currency_abbreviation;
    @Setter @Getter
    private String currency_symbol;

    public Country(){

    }
    public Country(String id, Float maximum_discount_percentage, String currency_abbreviation, String currency_symbol){
        this.id=id;
        this.maximum_discount_percentage = maximum_discount_percentage;
        this.currency_abbreviation = currency_abbreviation;
        this.currency_symbol = currency_symbol;
    }
}
