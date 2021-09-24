package com.santiquiroz.restapi.controllers;

import com.santiquiroz.restapi.dao.ProductDao;
import com.santiquiroz.restapi.dao.ProductXCategoryDao;
import com.santiquiroz.restapi.models.Product;
import com.santiquiroz.restapi.models.ProductXCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductXCategoryDao productXCategoryDao;

    @RequestMapping(value = "product/mostsearched/{amount}", method = RequestMethod.GET)
    public Object[] getMostSearched(@PathVariable Integer amount){
        Object[] productsData = new Object[2];  
        List<Product> products = productDao.getMostSearched(amount);
        ArrayList<List<ProductXCategory>> productXCategories = new ArrayList();
        for (Product product:products) {
            productXCategories.add(productXCategoryDao.getProductXCategoryByProductId(product.getId()));
        }
        productsData[0]=products;
        productsData[1]=productXCategories;
        return productsData;
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public void insertProduct(@RequestBody Product product){
        productDao.insert(product);
    }

    @RequestMapping(value = "product", method = RequestMethod.PUT)
    public void updateProduct(@RequestBody Product product){
        productDao.update(product);
    }
}
