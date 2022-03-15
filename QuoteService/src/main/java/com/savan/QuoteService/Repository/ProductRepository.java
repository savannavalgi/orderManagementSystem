package com.savan.QuoteService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savan.QuoteService.Models.Product;


public interface ProductRepository extends JpaRepository<Product,String>{

}
