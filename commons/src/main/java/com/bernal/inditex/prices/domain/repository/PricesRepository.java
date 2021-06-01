package com.bernal.inditex.prices.domain.repository;

import com.bernal.inditex.prices.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<Price, Long> {

}
