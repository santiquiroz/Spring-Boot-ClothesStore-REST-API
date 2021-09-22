package com.santiquiroz.restapi.controllers;

import com.santiquiroz.restapi.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @RequestMapping(value = "product/mostsearched/{ammount}")
    public Product[] getMostSearched(@PathVariable Integer ammount){
        Product[] mostSearchedProducts = new Product[1];
        return mostSearchedProducts;
    }
}
