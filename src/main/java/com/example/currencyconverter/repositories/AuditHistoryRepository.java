package com.example.currencyconverter.repositories;

import com.example.currencyconverter.models.AuditEntry;
import com.example.currencyconverter.models.AuditHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditHistoryRepository extends CrudRepository<AuditHistory, String> {

}
