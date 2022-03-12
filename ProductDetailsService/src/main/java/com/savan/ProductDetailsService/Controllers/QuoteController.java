package com.savan.ProductDetailsService.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.savan.ProductDetailsService.Models.Quote;

@RestController
public class QuoteController {
	@Autowired
	Environment env;
	
	@GetMapping("quote/{productId}/{countryId}")
	Quote getPrice(@PathVariable("productId") String productId, @PathVariable("countryId") String countryId) {
		
		String port = env.getProperty("local.server.port");
		
		// these values are currently hard coded. can be enhanced. 
					float discount = 10;
					float tax = 5;
					String currency = "rupees";
					System.out.println("==============savan============ ProductDetails/"+productId+" request received");
					Map<String,Integer> map = new HashMap<>();
					map.put("1",100);
					map.put("2",200);
					map.put("3",300);
					map.put("4",400);
					map.put("5",500);
					map.put("6",600);
		
		
		
		float productPrice = map.get(productId);
		
		float totalQuotePrice = productPrice - discount + tax;
		
		
		Quote response = new Quote(productId, countryId, currency, tax, discount, port);
		response.setProductPrice(productPrice);
		response.setTotalQuotePrice(totalQuotePrice);
						
		return response;
	}
}
