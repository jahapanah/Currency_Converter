package com.example.currencyconverter.controllers;

import com.example.currencyconverter.services.AuditHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyconverter.models.AuditHistory;

@RestController
public class CurrencyConverterHistoryController {
	@Autowired
	AuditHistoryService auditHistoryService;
	
	public CurrencyConverterHistoryController(AuditHistoryService auditHistoryService){
		this.auditHistoryService = auditHistoryService;
	}
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	 public ResponseEntity<AuditHistory> getAuditHistory(){
		 return new ResponseEntity<>(this.auditHistoryService.getAuditHistory(), HttpStatus.OK);
		
	}
}
