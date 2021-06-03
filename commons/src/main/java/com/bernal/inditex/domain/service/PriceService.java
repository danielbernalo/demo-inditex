package com.bernal.inditex.domain.service;

import com.bernal.inditex.domain.entity.Price;
import org.springframework.stereotype.Service;

@Service
public interface PriceService {
	Price findWithPeriodTime(Long currentDate, Long brandId, Long productId);

	void save(Price item);
}
