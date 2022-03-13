package com.savan.OrderService.Model;

public class Payment {
	Long orderId;
	String paymentLink;
	float totalQuotePrice;
	
	
	public Payment(Long orderId, String paymentLink, float totalQuotePrice) {
		super();
		this.orderId = orderId;
		this.paymentLink = paymentLink;
		this.totalQuotePrice = totalQuotePrice;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getPaymentLink() {
		return paymentLink;
	}
	public void setPaymentLink(String paymentLink) {
		this.paymentLink = paymentLink;
	}
	public float getTotalQuotePrice() {
		return totalQuotePrice;
	}
	public void setTotalQuotePrice(float totalQuotePrice) {
		this.totalQuotePrice = totalQuotePrice;
	}
	
	
	
}
