package com.savan.ProductDetailsService.Models;

public class Quote {
	String productId;
	String countryId;
	float ProductPrice;
	String currency;
	float tax;
	float discount;
	float totalQuotePrice;
	String port;
	
	
	
	
	
	public Quote(String productId, String countryId, String currency, float tax, float discount, String port) {
		super();
		this.productId = productId;
		this.countryId = countryId;
		this.currency = currency;
		this.tax = tax;
		this.discount = discount;
		this.port = port;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
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