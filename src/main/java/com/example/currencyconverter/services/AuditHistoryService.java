package com.example.currencyconverter.services;

import org.springframework.stereotype.Service;

import com.example.currencyconverter.models.AuditHistory;


public interface AuditHistoryService {

	public void addAuditEntry(String auditEntry);
	public AuditHistory getAuditHistory();
}
