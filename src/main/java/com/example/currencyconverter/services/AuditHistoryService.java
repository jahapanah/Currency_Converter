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

	@Autowired
	private AuditHistoryRepository auditRepository;

	public AuditHistoryService(AuditHistoryRepository auditRepository) {
		this.auditRepository = auditRepository;
	}

	public void addAuditEntry(String user, String queryString) {
		AuditHistory queryHistory = getAuditHistory(user);
		queryHistory.addNewAuditEntry(queryString);
		saveQueryHistory(queryHistory);
	}

	public AuditHistory getAuditHistory(String user){
		Optional<AuditHistory> queryHistory = auditRepository.findById(user);
		return queryHistory.orElse(createNewQueryHistory(user));
	}
	
	private AuditHistory createNewQueryHistory(String user) {
		return new AuditHistory(user);
	}

	private void saveQueryHistory(AuditHistory queryHistory) {
		auditRepository.save(queryHistory);
	}

}
