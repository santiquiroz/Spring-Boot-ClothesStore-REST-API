package com.santiquiroz.restapi.dao;

import com.santiquiroz.restapi.models.Country;
import com.santiquiroz.restapi.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class CountryDaoImp implements CountryDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Country getCountry(String id) {
        String query = "SELECT c FROM Country c WHERE c.id = (?1)";
        Country country = entityManager.createQuery(query, Country.class)
                .setParameter(1,id)
                .getSingleResult();
        return country;
    }

    @Override
    public void insert(Country country) {
        String query = "INSERT INTO country (id, maximum_discount_percentage, currency_abbreviation, currency_symbol) VALUES (?, ?, ?, ?)";
        entityManager.createNativeQuery(query).setParameter(1,country.getId())
                .setParameter(2,country.getMaximum_discount_percentage())
                .setParameter(3,country.getCurrency_abbreviation())
                .setParameter(4,country.getCurrency_symbol())
                .executeUpdate();
    }

    @Override
    public void update(Country country) {
        entityManager.merge(country);
    }

    @Override
    public void delete(String id) {
        Country country = getCountry(id);
        entityManager.remove(country);
    }
}
