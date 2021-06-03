package com.bernal.inditex.prices.api.rest.com.bernal.inditex.prices.api.domain.converters;

import static com.bernal.inditex.domain.converters.Utils.parseLongToDate;

import com.bernal.inditex.domain.entity.Price;
import com.bernal.inditex.domain.errors.ParseDateException;
import com.bernal.inditex.prices.api.rest.com.bernal.inditex.prices.api.domain.PriceDTO;
import org.springframework.stereotype.Component;

@Component
public class PriceToPriceDTO {

	public PriceDTO transform(Price source) throws ParseDateException {
		if (source == null) {
			return null;
		}
		return PriceDTO.builder()
			.productID(source.getProductId())
			.brandID(source.getBrandId())
			.priceList(source.getPriceList())
			.startDate(parseLongToDate(source.getStarDate()))
			.endDate(parseLongToDate(source.getEndDate()))
			.price(source.getPrice())
			.build();
	}
}
