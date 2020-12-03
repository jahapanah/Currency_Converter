package com.example.currencyconverter.models;


import org.springframework.data.redis.core.RedisHash;


public class AuditEntry {

	private String queryString;
	
	public AuditEntry() {
		super();
	}
	
	public AuditEntry(String queryString) {
		this.queryString = queryString;
	}
	
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
