package com.example.currencyconverter.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyconverter.models.AuditEntry;
import com.example.currencyconverter.models.AuditHistory;
import com.example.currencyconverter.models.Currency;
import com.example.currencyconverter.services.AuditHistoryService;

@RestController
public class CurrencyConverterHistoryController {

	AuditHistoryService auditHistoryService;
	
	public CurrencyConverterHistoryController(AuditHistoryService auditHistoryService){
		this.auditHistoryService = auditHistoryService;
	}
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	 public ResponseEntity<AuditHistory> getAuditHistory(){
		 return new ResponseEntity<>(this.auditHistoryService.getAuditHistory(), HttpStatus.OK);
		
	}
}