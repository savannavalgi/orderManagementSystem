package com.savan.ProductDetailsService.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	Environment env;
	
	@GetMapping("quote/{productId}")
	Integer getPrice(@PathVariable("productId") int productId) {
		
		String port = env.getProperty("local.server.port");
		System.out.println("==============savan============ ProductDetails/"+productId+" request received");
		
		Map<Integer,Integer> map = new HashMap<>();
		map.put(1,10);
		map.put(2,20);
		map.put(3,30);
		map.put(4,40);
		map.put(5,50);
		map.put(6,60);
		
//		return Integer.parseInt(port);
		
		if(map.containsKey(productId))
			return map.get(productId);
		else
			return -1;
	}
}
