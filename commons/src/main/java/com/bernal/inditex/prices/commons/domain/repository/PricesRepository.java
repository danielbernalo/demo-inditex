package com.bernal.inditex.prices.commons.domain.repository;

import com.bernal.inditex.prices.commons.domain.entity.PriceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends CrudRepository<PriceEntity, Integer> {
}
