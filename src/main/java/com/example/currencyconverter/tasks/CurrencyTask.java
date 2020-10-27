package com.example.currencyconverter.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.currencyconverter.models.Currency;
import com.example.currencyconverter.models.CurrencyDTO;
import com.example.currencyconverter.repositories.CurrencyRepository;

@Component
public class CurrencyTask {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Value("${fixer.io.apiKey}")
    private String fixerIoApiKey;


    // Runs every 5 hr
    @Scheduled(fixedRate = 5 * 1000*60*60)
    private void getRatesTask() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            CurrencyDTO forObject = restTemplate.getForObject(fixerIoApiKey, CurrencyDTO.class);
            forObject.getRates().forEach((key, value) -> {
                Currency currency = new Currency(key, value);
                this.currencyRepository.save(currency);
            });
        } catch (RestClientException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
