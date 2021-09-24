package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.Product;
import com.santiquiroz.restapi.models.ProductXCategory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductXCategoryDaoImpTest {

    @Autowired
    private ProductXCategoryDao productXCategoryDao;

    @Test
    @Order(1)
    public void failsIfInsertsADuplicateId(){
        //Expecting an exception after insert a duplicate id
        assertThatExceptionOfType(DataIntegrityViolationException.class).isThrownBy(() -> {
            //populating with test data
            ProductXCategory productXCategory = new ProductXCategory("2","2");
            productXCategoryDao.insert(productXCategory);
            productXCategory = new ProductXCategory("3","3");
            productXCategoryDao.insert(productXCategory);
            productXCategory = new ProductXCategory("4","4");
            productXCategoryDao.insert(productXCategory);
            productXCategory = new ProductXCategory("5","5");
            productXCategoryDao.insert(productXCategory);
            productXCategory = new ProductXCategory("6","6");
            productXCategoryDao.insert(productXCategory);
            productXCategory = new ProductXCategory("7","7");
            productXCategoryDao.insert(productXCategory);
            productXCategory = new ProductXCategory("8","8");
            productXCategoryDao.insert(productXCategory);
            productXCategory = new ProductXCategory("9","9");
            productXCategoryDao.insert(productXCategory);

            //creating a database integrity violation
            productXCategory = new ProductXCategory("1","1");

            productXCategoryDao.insert(productXCategory);
            productXCategoryDao.insert(productXCategory);
        });

    }

    @Test
    @Order(2)
    public void getsAllCategories(){
        List<ProductXCategory> productXCategory = productXCategoryDao.getAll();
        assertThat(productXCategory).hasSizeGreaterThanOrEqualTo(1);
    }

/*
    @Test
    @Order(3)
    public void getsAtLeastOneProductXCategoryByProductId(){
        //Expecting at least one
        String product_id="5";
        //executing
        List<ProductXCategory> productXCategory = productXCategoryDao.getProductXCategoryByProductId(product_id);
        assertThat(productXCategory).hasSizeGreaterThanOrEqualTo(1);
    }

    @Test
    @Order(4)
    public void getsAtLeastOneProductXCategoryByCategoryId(){
        //Expecting at least One
        String category_id="5";
        //executing
        List<ProductXCategory> productXCategory = productXCategoryDao.getProductXCategoryByCategoryId(category_id);
        assertThat(productXCategory).hasSizeGreaterThanOrEqualTo(1);
    }

    @Test
    @Order(5)
    public void getsAProductXCategory(){
        //Expecting a not null product as return
        //Executing
        assertThat(productXCategoryDao.getProductXCategory("1","1")).isNotNull();
    }

    @Test
    @Order(6)
    public void updates(){
        //Expecting no Exceptions while updating
        //Expecting different between oldProductXCategory and updatedProductXCategory
        ProductXCategory productXCategory = new ProductXCategory("2","2");
        ProductXCategory oldProductXCategory = productXCategoryDao.getProductXCategory("2","2");
        //Executing
        Assertions.assertAll(
                () -> assertDoesNotThrow(() ->productXCategoryDao.update(productXCategory))
        );
    }

    @Test
    @Order(7)
    public void deletes() {
        for (int i = 1; i <= 9; i++) {
            productXCategoryDao.delete(""+i , ""+i);
        }
        assertThatExceptionOfType(EmptyResultDataAccessException.class).isThrownBy(() -> {
            productXCategoryDao.getProductXCategory("4","4");
        });

    }
*/
}
