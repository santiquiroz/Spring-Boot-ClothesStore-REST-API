package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import javax.persistence.PersistenceException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDaoImpTest {

    @Autowired
    private ProductDaoImp productDaoImp;

    @Test
    @Order(1)
    public void failsIfInsertsADuplicateId(){
        //Expecting an exception after insert a duplicate id
        assertThatExceptionOfType(DataIntegrityViolationException.class).isThrownBy(() -> {
            //populating with test data
            Product product = new Product("2","blanco mas blando que la nieve blanca. Ideal para bodas.",10,"[]");
            productDaoImp.insert(product);
            product = new Product("3","blanco mas blando que la nieve blanca. Ideal para bodas.",10,"[]");
            productDaoImp.insert(product);
            product = new Product("4","blanco mas blando que la nieve blanca. Ideal para bodas.",10,"[]");
            productDaoImp.insert(product);
            product = new Product("5","blanco mas blando que la nieve blanca. Ideal para bodas.",10,"[]");
            productDaoImp.insert(product);
            product = new Product("6","blanco mas blando que la nieve blanca. Ideal para bodas.",10,"[]");
            productDaoImp.insert(product);
            product = new Product("7","blanco mas blando que la nieve blanca. Ideal para bodas.",10,"[]");
            productDaoImp.insert(product);
            product = new Product("8","blanco mas blando que la nieve blanca. Ideal para bodas.",10,"[]");
            productDaoImp.insert(product);
            product = new Product("9","blanco mas blando que la nieve blanca. Ideal para bodas.",10,"[]");
            productDaoImp.insert(product);

            //creating a database integrity violation
            product = new Product("1","blanco mas blando que la nieve blanca. Ideal para bodas.",10,"[]");

            productDaoImp.insert(product);
            productDaoImp.insert(product);
        });

    }

    @Test
    @Order(2)
    public void getsNOrLessMostSearchedProducts(){
        //Expecting a list of 5 or less elements
        Integer n=5;
        //executing
        List<Product> products = productDaoImp.getMostSearched(n);
        assertThat(products).hasSizeLessThanOrEqualTo(n);
    }

    @Test
    @Order(3)
    public void getsAProduct(){
        //Expecting a not null product as return
        //Executing
        assertThat(productDaoImp.getProduct("1")).isNotNull();
    }

    @Test
    @Order(4)
    public void updates(){
        //Expecting no Exceptions while updating
        //Expecting different between oldProduct and updatedProduct
        Product product = new Product("2","blanco mas blando que la nieve blanca. Ideal para bodas.",11,"[]");
        Product oldProduct = productDaoImp.getProduct("2");
        //Executing
        Assertions.assertAll(
                () -> assertDoesNotThrow(() ->productDaoImp.update(product)),
                () -> assertNotEquals((productDaoImp.getProduct("2")).getNumber_of_searches(),oldProduct.getNumber_of_searches())
        );
    }

    @Test
    @Order(5)
    public void deletes() {
        for (int i = 1; i <= 9; i++) {
            productDaoImp.delete(""+i );
        }
        assertThatExceptionOfType(EmptyResultDataAccessException.class).isThrownBy(() -> {
            productDaoImp.getProduct("4");
        });

    }
}
