package com.example.currencyconverter.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.currencyconverter.models.AuditHistory;

@Repository
public interface AuditHistoryRepository extends CrudRepository<AuditHistory, String> {

}
