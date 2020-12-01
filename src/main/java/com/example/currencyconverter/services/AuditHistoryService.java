package com.example.currencyconverter.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.currencyconverter.models.AuditHistory;
import com.example.currencyconverter.repositories.AuditHistoryRepository;


@Service
public class AuditHistoryService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuditHistoryService.class);

	AuditHistoryRepository auditHistoryRepository;

	public AuditHistoryService(AuditHistoryRepository auditHistoryRepository) {
		this.auditHistoryRepository = auditHistoryRepository;
	}

	public void addAuditEntry(String queryString) {
		AuditHistory queryHistory = new AuditHistory();
		queryHistory.addNewAuditEntry(queryString);
		saveQueryHistory(queryHistory);
	}

	public AuditHistory getAuditHistory(){
		Optional<Iterable<AuditHistory>> queryHistory = Optional.ofNullable(auditHistoryRepository.findAll());
		return (AuditHistory) queryHistory.orElse(createNewQueryHistory());
	}
	
	private Iterable<AuditHistory> createNewQueryHistory() {
		Iterable<AuditHistory> iterable = (Iterable<AuditHistory>) new AuditHistory();
		return iterable;
	}

	private void saveQueryHistory(AuditHistory queryHistory) {
		auditHistoryRepository.save(queryHistory);
	}

}
