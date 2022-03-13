package com.savan.QuoteService.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.savan.QuoteService.Models.Quote;

@RestController
public class QuoteController {
	@Autowired
	Environment env;
	
	@GetMapping("quote/productId/{productId}/country/{country}")
	Quote getPrice(@PathVariable("productId") String productId, @PathVariable("country") String country) {
		
		String port = env.getProperty("local.server.port");
		
		// these values are currently hard coded. can be enhanced. 
					float discount = 10;
					float tax = 5;
					System.out.println("==============savan============ ProductDetails/"+productId+" request received");
					Map<String,Integer> productMap = new HashMap<>();
					productMap.put("1",100);
					productMap.put("2",200);
					productMap.put("3",300);
					productMap.put("4",400);
					productMap.put("5",500);
					productMap.put("6",600);
					
					Map<String,String> countryMap = new HashMap<>();
					countryMap.put("India","Rupees");
					countryMap.put("US","Dollars");
		
		
		
		float productPrice = productMap.get(productId);
		String currency = countryMap.get(country);
		float totalQuotePrice = productPrice - discount + tax;
		
		
		Quote response = new Quote(productId, country, currency, tax, discount, port);
		response.setProductPrice(productPrice);
		response.setTotalQuotePrice(totalQuotePrice);
						
		return response;
	}
}
