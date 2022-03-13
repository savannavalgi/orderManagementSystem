package com.savan.OrderService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savan.OrderService.Model.Quote;

public interface QuoteRepository extends JpaRepository<Quote,Long>{

}
