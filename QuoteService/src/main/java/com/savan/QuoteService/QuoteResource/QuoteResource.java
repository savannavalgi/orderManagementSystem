package com.savan.QuoteService.QuoteResource;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savan.QuoteService.Exceptions.ProductNotFoundException;
import com.savan.QuoteService.Models.Product;
import com.savan.QuoteService.Models.Quote;
import com.savan.QuoteService.Repository.ProductRepository;

@Service
public class QuoteResource {
	
	@Autowired
	ProductRepository productRepo;
	
	
	Quote quote;
	
	public Quote getQuote() {
		return quote;
	}
	
	QuoteResource(){
		quote = new Quote();
	}
	
	void getCurrency(){
		Map<String,String> countryMap = new HashMap<>();
		countryMap.put("India","Rupees");
		countryMap.put("US","Dollars");
		
		String currency = countryMap.get(quote.getCountry());
		quote.setCurrency(currency);
		
		return ;
	}
	
	public Quote getQuotation(String productId, String country) throws ProductNotFoundException{
		
		quote.setCountry(country);
		quote.setProductId(productId);
		
		//get Currency
		getCurrency();
		
		// get product price from the repository
		Optional<Product> product = productRepo.findById(quote.getProductId());
		
		if(product.isEmpty())
			throw new ProductNotFoundException("This product is not present");
		
		
		float productPrice = product.get().getProductPrice();
		quote.setProductPrice(productPrice);
		
		//	calculate total quote price
		calculateTotalPrice();
						
		return quote;
	}
	
	void calculateTotalPrice() {
		// these values are currently hard coded. can be enhanced.
		float discount = 10;
		quote.setDiscount(discount);
		float tax = 5;
		quote.setTax(tax);
		
		float productPrice = quote.getProductPrice();
		
		float totalQuotePrice =productPrice * (1 - (discount/100) + (tax/100));
		
		quote.setTotalQuotePrice(totalQuotePrice);
		return;
	}

}
