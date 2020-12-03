package com.example.currencyconverter.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.LinkedList;

@RedisHash("AuditHistory")
public class AuditHistory {

	@Id
	String user;

	private LinkedList<AuditEntry> auditEntries;
	
	public AuditHistory(String user){
		this.user = user;
		this.auditEntries = new LinkedList<>();
	}
	
	public String getUser() {
		return user;
	}

	public void setUsername(String user) {
		this.user = user;
	}


	public LinkedList<AuditEntry> getAuditEntries() {
		return auditEntries;
	}

	public void setAuditEntries(LinkedList<AuditEntry> auditEntries) {
		this.auditEntries = auditEntries;
	}
	
	
	public void addNewAuditEntry(String queryString) {
		AuditEntry newEntry = createNewAuditEntry(queryString);
		if (this.auditEntries.size() == 10)
			this.auditEntries.removeLast();

		this.auditEntries.addFirst(newEntry);
	}
	
	private AuditEntry createNewAuditEntry(String queryString) {
		return new AuditEntry(queryString);
	}
	
	public String getFormattedString() {
		StringBuilder formatted = new StringBuilder();
		getAuditEntries().stream()
				.forEach((p) -> formatted.append(p.getQueryString())
						.append("\n"));
		return formatted.toString();

	}
}
