package com.savan.OrderService.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long quoteId;
	String productId;
	String country;
	float ProductPrice;
	String currency;
	float tax;
	float discount;
	float totalQuotePrice;
	String port;
	
	public Quote(String productId, String country, String currency, float tax, float discount, String port) {
		super();
		this.productId = productId;
		this.country = country;
		this.currency = currency;
		this.tax = tax;
		this.discount = discount;
		this.port = port;
	}
	
	public Quote() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getQuoteId() {
		return quoteId;
	}



	public void setQuoteId(Long quoteId) {
		this.quoteId = quoteId;
	}



	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountryId(String country) {
		this.country = country;
	}
	public float getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(float productPrice) {
		ProductPrice = productPrice;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getTotalQuotePrice() {
		return totalQuotePrice;
	}
	public void setTotalQuotePrice(float totalQuotePrice) {
		this.totalQuotePrice = totalQuotePrice;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
	
	
}
