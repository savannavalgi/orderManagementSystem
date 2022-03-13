package com.savan.OrderService.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderInformation")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long orderId;
	Long customerId;
	Long quoteId;
	boolean paymentSuccess;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(Long customerId, Long quoteId) {
		super();
		this.customerId = customerId;
		this.quoteId = quoteId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(Long quoteId) {
		this.quoteId = quoteId;
	}
	public boolean isPaymentSuccess() {
		return paymentSuccess;
	}
	public void setPaymentSuccess(boolean paymentSuccess) {
		this.paymentSuccess = paymentSuccess;
	}
	
	
}
