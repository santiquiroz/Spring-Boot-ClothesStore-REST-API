package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.Country;
import com.santiquiroz.restapi.models.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CountryDaoImpTest {

    @Autowired
    private CountryDaoImp countryDaoImp;

    @Test
    @Order(1)
    public void failsIfInsertsADuplicateId(){
        //Expecting an exception after insert a duplicate id
        assertThatExceptionOfType(DataIntegrityViolationException.class).isThrownBy(() -> {
            //populating with test data
            Country country = new Country("2",0.5f,"COP","$");
            countryDaoImp.insert(country);
            country = new Country("3",0.5f,"COP","$");
            countryDaoImp.insert(country);
            country = new Country("4",0.5f,"COP","$");
            countryDaoImp.insert(country);
            country = new Country("5",0.5f,"COP","$");
            countryDaoImp.insert(country);
            country = new Country("6",0.5f,"COP","$");
            countryDaoImp.insert(country);
            country = new Country("7",0.5f,"COP","$");
            countryDaoImp.insert(country);
            country = new Country("8",0.5f,"COP","$");
            countryDaoImp.insert(country);
            country = new Country("9",0.5f,"COP","$");
            countryDaoImp.insert(country);

            //creating a database integrity violation
            country = new Country("1",0.5f,"COP","$");

            countryDaoImp.insert(country);
            countryDaoImp.insert(country);
        });

    }

    @Test
    @Order(2)
    public void getsACountry(){
        //Expecting a not null product as return
        //Executing
        assertThat(countryDaoImp.getCountry("1")).isNotNull();
    }

    @Test
    @Order(3)
    public void updates(){
        //Expecting no Exceptions while updating
        //Expecting different between oldProduct and updatedProduct
        Country country = new Country("2",0.8f,"COP","$");
        Country oldCountry = countryDaoImp.getCountry("2");
        //Executing
        Assertions.assertAll(
                () -> assertDoesNotThrow(() ->countryDaoImp.update(country)),
                () -> assertNotEquals((countryDaoImp.getCountry("2")).getMaximum_discount_percentage(),oldCountry.getMaximum_discount_percentage())
        );
    }

    @Test
    @Order(4)
    public void deletes() {
        for (int i = 1; i <= 9; i++) {
            countryDaoImp.delete(""+i );
        }
        assertThatExceptionOfType(EmptyResultDataAccessException.class).isThrownBy(() -> {
            countryDaoImp.getCountry("4");
        });

    }
}
