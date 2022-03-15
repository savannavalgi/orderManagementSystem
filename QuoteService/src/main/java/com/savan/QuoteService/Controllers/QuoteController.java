package com.savan.QuoteService.Controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.savan.QuoteService.Models.Product;
import com.savan.QuoteService.Models.Quote;
import com.savan.QuoteService.Repository.ProductRepository;


@RestController
public class QuoteController {
	@Autowired
	Environment env;
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("quote/productId/{productId}")
	ResponseEntity getPrice(@PathVariable("productId") String productId, 
			@RequestParam("country") String country){
		
		// these values are currently hard coded. can be enhanced. 
		float discount = 10;
		float tax = 5;
		Map<String,String> countryMap = new HashMap<>();
		countryMap.put("India","Rupees");
		countryMap.put("US","Dollars");
		
		// fetch currency and port number
		String currency = countryMap.get(country);
		String port = env.getProperty("local.server.port");
		
		// get product price from the repository
		Optional<Product> product = productRepo.findById(productId);
		if(!product.isPresent()) {
			return new ResponseEntity<String>("this product is not available",HttpStatus.CONFLICT);
		}
		float productPrice = product.get().getProductPrice();
		
		
		//	calculate total quote price
		float totalQuotePrice = productPrice * (1 - (discount/100) + (tax/100));
		
		
		// build the quote object
		Quote quote = new Quote(productId, country, currency, tax, discount, port);
		quote.setProductPrice(productPrice);
		quote.setTotalQuotePrice(totalQuotePrice);
						
		return new ResponseEntity<Quote>(quote,HttpStatus.OK);
	}
	
}
