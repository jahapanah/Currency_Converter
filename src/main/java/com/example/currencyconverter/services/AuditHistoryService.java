package com.example.currencyconverter.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.currencyconverter.models.AuditEntry;
import com.example.currencyconverter.models.AuditHistory;
import com.example.currencyconverter.repositories.AuditHistoryRepository;


@Service
public class AuditHistoryService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuditHistoryService.class);

	@Autowired
	private AuditHistoryRepository auditRepository;

	public AuditHistoryService(AuditHistoryRepository auditRepository) {
		this.auditRepository = auditRepository;
	}

	public void addAuditEntry(String user, String queryString) {
		AuditHistory queryHistory = new AuditHistory(user);
		queryHistory.addNewAuditEntry(queryString);
		saveQueryHistory(queryHistory);
	}

	public Optional<Optional<AuditHistory>> getAuditHistory(String user){
		Optional<Optional<AuditHistory>> queryHistory = Optional.ofNullable(auditRepository.findById(user));
		return queryHistory;
	}
	
	private Iterable<AuditHistory> createNewQueryHistory() {
		Iterable<AuditHistory> iterable = (Iterable<AuditHistory>) new AuditHistory(null);
		return iterable;
	}

	private void saveQueryHistory(AuditHistory queryHistory) {
		auditRepository.save(queryHistory);
	}

}
