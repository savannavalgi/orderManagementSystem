package com.savan.OrderService.Model;

public class Order {
	String orderId;
	String customerId;
	String productId;
	int price;
	

	@Override
	public String toString() {
		return String.format("Order [orderId=%s, customerId=%s, productId=%s, price=%s]", orderId, customerId,
				productId, price);
	}
	
	public Order(String orderId, String customerId, String productId, int price) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.productId = productId;
		this.price = price;
	}
	
}
