package com.example.currencyconverter;

import com.example.currencyconverter.repositories.AuditHistoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.currencyconverter.models.AuditHistory;
import com.example.currencyconverter.models.ConversionCurrency;
import com.example.currencyconverter.models.Currency;
import com.example.currencyconverter.repositories.CurrencyRepository;
import com.example.currencyconverter.services.AuditHistoryService;
import com.example.currencyconverter.services.CurrencyService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UnitTests {

    @Mock
    private CurrencyRepository repository;
    
    @Mock 
    AuditHistoryRepository auditHistoryRepo;
    
    @Spy 
	AuditHistory history= new AuditHistory("admin");

    private CurrencyService subject;
    
    private AuditHistoryService auditHistoryService;
    
    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void setup() {
        subject = new CurrencyService(repository);
        auditHistoryService = new AuditHistoryService(auditHistoryRepo);

    }
    
    //Unit tests for currency conversion

    @Test
    public void getAllCurrenciesTestEmpty () {
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList());

        List<Currency> currencies = subject.getAllCurrencies();
        Assert.assertTrue(currencies.isEmpty());
    }

    @Test
    public void convertShouldReturnEmptyWhenNegativeValue() {
        Currency currencyEUR = new Currency("EUR", 1);
        Currency currencyUSD = new Currency("USD", 0.8);


        Mockito.when(repository.findById("EUR")).thenReturn(Optional.of(currencyEUR));
        Mockito.when(repository.findById("USD")).thenReturn(Optional.of(currencyUSD));

        ConversionCurrency conversionCurrency = new ConversionCurrency("EUR", "USD", -10);

        Optional<Double> result = subject.convert(conversionCurrency);


        Assert.assertNotNull(result);
        Assert.assertFalse(result.isPresent());
    }

    @Test
    public void convertShouldReturnEmptyWhenCurrencyDoesNotExist() {
        Currency currencyUSD = new Currency("USD", 0.8);

        Mockito.when(repository.findById("EUR")).thenReturn(Optional.empty());
        Mockito.when(repository.findById("USD")).thenReturn(Optional.of(currencyUSD));

        ConversionCurrency conversionCurrency = new ConversionCurrency("EUR", "USD", 0);

        Optional<Double> result = subject.convert(conversionCurrency);

        Assert.assertNotNull(result);
        Assert.assertFalse(result.isPresent());
    }
    
    //Unit tests added for AuditHistory functionality
    
    @Test
    public void getAuditHistoryReturnHistory(){
    	Mockito.when(auditHistoryRepo.findById("admin")).thenReturn(Optional.of(history));
    	
    }@Test
    public void addAuditEntrySpec(){
    	String queryString= "queryString";
    	Mockito.doCallRealMethod().when(history).addNewAuditEntry(queryString);
    	
    }

}
