package com.santiquiroz.restapi.controllers;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.santiquiroz.restapi.dao.ProductDao;
import com.santiquiroz.restapi.dao.ProductXCategoryDao;
import com.santiquiroz.restapi.dao.ProductXCountryDao;
import com.santiquiroz.restapi.models.Product;
import com.santiquiroz.restapi.models.ProductXCategory;
import com.santiquiroz.restapi.models.ProductXCountry;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@JsonSerializableSchema
class GetMostSearchedResponseJSON implements Serializable {
    @Setter @Getter
    private Product product;
    @Setter @Getter
    private List<ProductXCategory> productXCategories;
    public GetMostSearchedResponseJSON(Product product, List<ProductXCategory> productXCategoryByProductId){
        this.product = product;
        this.productXCategories = productXCategoryByProductId;
    }
}

@JsonSerializableSchema
class InsertProductRequest implements Serializable {
    @Setter @Getter
    private Product product;
    @Setter @Getter
    private List<ProductXCategory> productXCategories;
    @Setter @Getter
    private List<ProductXCountry> productXCountries;
}

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductXCategoryDao productXCategoryDao;
    @Autowired
    private ProductXCountryDao productXCountryDao;


    @RequestMapping(value = "product/mostsearched/{amount}", method = RequestMethod.GET)
    public ArrayList<GetMostSearchedResponseJSON> getMostSearched(@PathVariable Integer amount){
        List<Product> products = productDao.getMostSearched(amount);
        ArrayList<GetMostSearchedResponseJSON> productsData = new ArrayList();
        for (Product product:products) {
            productsData.add(new GetMostSearchedResponseJSON(product, productXCategoryDao.getProductXCategoryByProductId(product.getId())));
        }
        return productsData;
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public void insertProduct(@RequestBody InsertProductRequest insertProductRequest){
        productDao.insert(insertProductRequest.getProduct());
        for (ProductXCategory productXCategory: insertProductRequest.getProductXCategories()) {
            productXCategoryDao.insert(productXCategory);
        }
        for (ProductXCountry productXCountry: insertProductRequest.getProductXCountries()) {
            productXCountryDao.insert(productXCountry);
        }
    }

    @RequestMapping(value = "product", method = RequestMethod.PUT)
    public void updateProduct(@RequestBody Product product){
        productDao.update(product);
    }
    @RequestMapping(value = "product", method = RequestMethod.DELETE)
    public void deleteProduct(@RequestBody String id){
        List<ProductXCountry> productXCountries = productXCountryDao.getProductXCountryByProductId(id);
        for (ProductXCountry productXCountry:productXCountries) {
            productXCountryDao.delete(productXCountry.getProduct_id(),productXCountry.getCountry_id());
        }
        List<ProductXCategory> productXCategories = productXCategoryDao.getProductXCategoryByProductId(id);
        for (ProductXCountry productXCountry:productXCountries) {
            productXCountryDao.delete(productXCountry.getProduct_id(),productXCountry.getCountry_id());
        }
        productDao.delete(id);
    }

}
