package com.savan.OrderService.Model;

public class Order {
	String orderId;
	String customerId;
	Quote quote;
	boolean paymentSuccess;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Quote getQuote() {
		return quote;
	}
	public void setQuote(Quote quote) {
		this.quote = quote;
	}
	public boolean isPaymentSuccess() {
		return paymentSuccess;
	}
	public void setPaymentSuccess(boolean paymentSuccess) {
		this.paymentSuccess = paymentSuccess;
	}
	
	
}
