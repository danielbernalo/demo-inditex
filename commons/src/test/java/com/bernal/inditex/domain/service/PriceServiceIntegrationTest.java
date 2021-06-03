package com.bernal.inditex.domain.service;

import static com.bernal.inditex.BuilderPrices.BRAND_ID;
import static com.bernal.inditex.BuilderPrices.PRICE;
import static com.bernal.inditex.BuilderPrices.PRODUCT_ID;
import static com.bernal.inditex.domain.converters.Utils.parseDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.bernal.inditex.domain.entity.Price;
import com.bernal.inditex.domain.errors.ParseDateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ComponentScan("com.bernal.inditex")
class PriceServiceIntegrationTest {


	@Autowired
	 PriceService priceService;

	@Test
	@DisplayName("given a invalid date time when find a price in period time then return null")
	void testInvalidDateReturnNull() {
		Price price = priceService.findWithPeriodTime(1L, 1l, 1l);
		assertNull(price);
	}

	@Test
	@DisplayName("given a valid date time when find a price in period time then return best price")
	void testValidDateReturnBestPrice() throws ParseDateException {
		String CURRENT_DATE_TEST = "2020-06-14-10.00.00";
		Long parsedDateTime = parseDate(CURRENT_DATE_TEST);

		Price price = priceService.findWithPeriodTime(parsedDateTime, BRAND_ID, PRODUCT_ID);
		assertEquals(price.getPrice(), PRICE);
	}
}
