package com.example.currencyconverter.repositories;


import org.springframework.data.repository.CrudRepository;

import com.example.currencyconverter.models.Currency;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, String> {

    @Override
    List<Currency> findAll();
}

