package com.bernal.inditex;

import com.bernal.inditex.domain.entity.Price;

public class BuilderPrices {

	public static final String EUR_CURRENCY = "EUR";
	public static final Long BRAND_ID = 1L;
	public static final Long PRIORITY = 1L;
	public static final Long PRODUCT_ID = 35455L;
	public static final Double PRICE = 35.50;

	public static Price buildPriceWithDateTime(Long datetime, Double price) {
		return Price.builder()
			.priority(PRIORITY)
			.brandId(BRAND_ID)
			.currency(EUR_CURRENCY)
			.productId(PRODUCT_ID)
			.starDate(datetime)
			.price(price)
			.build();
	}
}
