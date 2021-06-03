package com.bernal.inditex.domain.service;

import com.bernal.inditex.domain.entity.Price;
import com.bernal.inditex.domain.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceServiceImpl implements PriceService {

	@Autowired
	PricesRepository pricesRepository;

	@Override
	public Price findWithPeriodTime(Long currentDate, Long brandId, Long productId) {
		return pricesRepository.findWithPeriodTime(currentDate, brandId, productId).stream().findFirst().orElse(null);
	}

	@Override
	public void save(Price item) {
		pricesRepository.save(item);
	}
}
