package com.santiquiroz.restapi.controllers;

import com.santiquiroz.restapi.dao.ProductDao;
import com.santiquiroz.restapi.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "product/mostsearched/{ammount}", method = RequestMethod.GET)
    public List<Product> getMostSearched(@PathVariable Integer ammount){
        return productDao.getMostSearched();
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public void insertProduct(@RequestBody Product product){
        productDao.insert(product);
    }

    @RequestMapping(value = "product", method = RequestMethod.PUT)
    public void updateProduct(){
        productDao.update();
    }
}
