package com.santiquiroz.restapi.models;
public class Product {


    private Integer id;
    private String p_description;
    private Integer number_of_searches;
    private String[] images;
    private Float price;
    private Float discount_percentage;
    private Float price_after_discount;
    private String currency_abbreviation;
    private String currency_symbol;
    private String[] category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getP_description() {
        return p_description;
    }

    public void setP_description(String p_description) {
        this.p_description = p_description;
    }

    public Integer getNumber_of_searches() {
        return number_of_searches;
    }

    public void setNumber_of_searches(Integer number_of_searches) {
        this.number_of_searches = number_of_searches;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(Float discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public Float getPrice_after_discount() {
        return price_after_discount;
    }

    public void setPrice_after_discount(Float price_after_discount) {
        this.price_after_discount = price_after_discount;
    }

    public String getCurrency_abbreviation() {
        return currency_abbreviation;
    }

    public void setCurrency_abbreviation(String currency_abbreviation) {
        this.currency_abbreviation = currency_abbreviation;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }

    public void setCurrency_symbol(String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }
}
