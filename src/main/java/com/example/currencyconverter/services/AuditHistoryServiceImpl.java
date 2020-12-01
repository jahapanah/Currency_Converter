package com.example.currencyconverter.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.currencyconverter.models.AuditHistory;
import com.example.currencyconverter.repositories.AuditHistoryRepository;


@Service
public class AuditHistoryServiceImpl implements AuditHistoryService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuditHistoryServiceImpl.class);
	
	AuditHistoryRepository auditRepository;

	public AuditHistoryServiceImpl(AuditHistoryRepository auditRepository) {
		super();
		this.auditRepository = auditRepository;
	}
	
	@Override
	public void addAuditEntry(String queryString) {
		AuditHistory queryHistory = new AuditHistory();
		queryHistory.addNewAuditEntry(queryString);
		saveQueryHistory(queryHistory);
	}
	
	@Override
	public AuditHistory getAuditHistory(){
		Optional<Iterable<AuditHistory>> queryHistory = Optional.ofNullable(auditRepository.findAll());
		return (AuditHistory) queryHistory.orElse(createNewQueryHistory());
	}
	
	private Iterable<AuditHistory> createNewQueryHistory() {
		Iterable<AuditHistory> iterable = (Iterable<AuditHistory>) new AuditHistory();
		return iterable;
	}

	private void saveQueryHistory(AuditHistory queryHistory) {
		auditRepository.save(queryHistory);
	}

}
