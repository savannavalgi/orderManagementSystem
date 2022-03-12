package com.savan.OrderService.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.savan.OrderService.Model.Order;

@RestController
public class OrderController {
	
	@PostMapping("/order/{customerId}/{orderId}/{productId}")
	String placeOrder(@PathVariable("customerId") String customerId,@PathVariable("orderId") String orderId,@PathVariable("productId") String productId) {
		List<Order> repo = new ArrayList<>();
		System.out.println("==============savan============ customerId "+customerId+" orderId "+orderId+" productId "+productId);
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		final String baseUrl = "http://localhost:8081/ProductDetails/"+productId;
		URI uri;
		try {
			uri = new URI(baseUrl);
			ResponseEntity<Integer> result = restTemplate.getForEntity(uri, Integer.class);
			System.out.println("==============savan============"+result.getBody());
			repo.add(new Order(orderId,customerId,productId,result.getBody()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		 
		
		
		return repo.toString();
	}
}
