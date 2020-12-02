package com.example.currencyconverter.models;

public class ConversionCurrency {

    private String to;
    private String from;

    private double value;

    public ConversionCurrency() {
    }

    public ConversionCurrency(String to, String from, double value) {
        this.to = to;
        this.from = from;
        this.value = value;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getAuditString() {
        StringBuilder auditString = new StringBuilder("Query:::").append(getValue())
                .append(" ").append(getFrom()).append("=>").append(getTo()).append(" as on ")
                .append("    Result:::");
        return auditString.toString();
    }
}
