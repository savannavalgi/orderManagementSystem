package com.savan.OrderService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savan.OrderService.Model.Order;

public interface OrderRepository  extends JpaRepository<Order,Long>{
	
}
