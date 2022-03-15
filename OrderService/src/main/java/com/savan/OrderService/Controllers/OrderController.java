package com.savan.OrderService.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.savan.OrderService.Model.Order;
import com.savan.OrderService.Model.Payment;
import com.savan.OrderService.Model.Quote;
import com.savan.OrderService.Repository.OrderRepository;
import com.savan.OrderService.Repository.QuoteRepository;

@RestController
public class OrderController {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	QuoteRepository quoteRepo;
	
	
	@PostMapping("/order/customerId/{customerId}")
	Payment placeOrder(@RequestBody Quote quote, @PathVariable("customerId") Long customerId) {
		
		// currently hard coded, can be enhanced.
		String paymentLink = "www.paymentlink.com";
		
		
		Long quoteId = quoteRepo.save(quote).getQuoteId();
		Order order = new Order(customerId,quoteId);
		Long orderId = orderRepo.save(order).getOrderId();
		Payment payment = new Payment(orderId,paymentLink, quote.getTotalQuotePrice());
		
		
		return payment;
	}
}
