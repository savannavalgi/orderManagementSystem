package com.savan.OrderService.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.savan.OrderService.Model.Order;
import com.savan.OrderService.Model.Quote;

@RestController
public class OrderController {
	
	@PostMapping("/order/")
	List<Order> placeOrder(@RequestBody Order o) {
		
		// hardcoded, later change it to enhance it.
		List<Order> repo = new ArrayList<>();
			
		 
		
		o.setOrderId("very good id"); // generate by db
		repo.add(o);
		Order o2 = new Order();
		o2.setOrderId("second iteam");
		repo.add(o2);
		return repo;
	}
}
