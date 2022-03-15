package com.savan.QuoteService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.savan.QuoteService.Exceptions.ProductNotFoundException;
import com.savan.QuoteService.Models.Quote;
import com.savan.QuoteService.QuoteResource.QuoteResource;


@RestController
public class QuoteController {
	@Autowired
	Environment env;
	
	@Autowired
	QuoteResource quoteResource;
	
	@GetMapping("quote/productId/{productId}")
	ResponseEntity getPrice(@PathVariable("productId") String productId, 
			@RequestParam("country") String country){
		
		String port = env.getProperty("local.server.port");
		
		
		try {
			Quote quote = quoteResource.getQuotation(productId,country);
			quote.setPort(port);
			
			return new ResponseEntity<Quote>(quote,HttpStatus.OK);
		}catch(ProductNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		
	}
	
}
