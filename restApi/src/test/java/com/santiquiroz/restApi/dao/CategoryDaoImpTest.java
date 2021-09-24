package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.Category;
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
public class CategoryDaoImpTest {
    @Autowired
    private CategoryDaoImp categoryDaoImp;

    @Test
    @Order(1)
    public void failsIfInsertsADuplicateId(){
        //Expecting an exception after insert a duplicate id
        assertThatExceptionOfType(DataIntegrityViolationException.class).isThrownBy(() -> {
            //populating with test data
            Category category = new Category("2");
            categoryDaoImp.insert(category);
            category = new Category("3");
            categoryDaoImp.insert(category);
            category = new Category("4");
            categoryDaoImp.insert(category);
            category = new Category("5");
            categoryDaoImp.insert(category);
            category = new Category("6");
            categoryDaoImp.insert(category);
            category = new Category("7");
            categoryDaoImp.insert(category);
            category = new Category("8");
            categoryDaoImp.insert(category);
            category = new Category("9");
            categoryDaoImp.insert(category);

            //creating a database integrity violation
            category = new Category("1");

            categoryDaoImp.insert(category);
            categoryDaoImp.insert(category);
        });
    }

    @Test
    @Order(2)
    public void getsAProduct(){
        //Expecting a not null category as return
        //Executing
        assertThat(categoryDaoImp.getCategory("1")).isNotNull();
    }

    @Test
    @Order(3)
    public void updates(){
        //Expecting no Exceptions while updating
        //Expecting different between oldCategory and updatedCategory
        Category category = new Category("2");
        Category OldCategory = categoryDaoImp.getCategory("2");
        //Executing
        Assertions.assertAll(
                () -> assertDoesNotThrow(() ->categoryDaoImp.update(category))
        );
    }

    @Test
    @Order(4)
    public void deletes() {
        for (int i = 1; i <= 9; i++) {
            categoryDaoImp.delete(""+i );
        }
        assertThatExceptionOfType(EmptyResultDataAccessException.class).isThrownBy(() -> {
            categoryDaoImp.getCategory("4");
        });

    }
}
