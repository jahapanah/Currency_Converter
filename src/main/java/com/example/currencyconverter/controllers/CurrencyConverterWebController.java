package com.example.currencyconverter.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CurrencyConverterWebController {

    @GetMapping("/")
    public String serveIndexWebPage() {
        return "index";
    }
    
	@GetMapping("/history")
	public String serveHistoryWebPage() {
		return "history";
	}
}
