package com.savan.QuoteService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savan.QuoteService.Models.CountryPrice;

public interface CountryPriceRepository extends JpaRepository<CountryPrice,Long> {

	Optional<CountryPrice> findByCountryAndProductId(String country, String productId);

}
