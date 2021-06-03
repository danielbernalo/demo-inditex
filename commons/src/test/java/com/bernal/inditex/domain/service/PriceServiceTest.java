package com.bernal.inditex.domain.service;

import static com.bernal.inditex.BuilderPrices.BRAND_ID;
import static com.bernal.inditex.BuilderPrices.PRICE;
import static com.bernal.inditex.BuilderPrices.PRODUCT_ID;
import static com.bernal.inditex.BuilderPrices.buildPriceWithDateTime;
import static com.bernal.inditex.domain.converters.Utils.parseDateToLong;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import com.bernal.inditex.domain.entity.Price;
import com.bernal.inditex.domain.errors.ParseDateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PriceServiceTest {


	@MockBean
	PriceService priceService;

	@Test
	@DisplayName("Unit:given a invalid date time then return null")
	void testKO() {
		//given
		when(priceService.findWithPeriodTime(1L, 1L, 1L)).thenReturn(null);
		//when
		Price result = priceService.findWithPeriodTime(1L, 1L, 1L);
		//then
		assertNull(result);

	}

	@Test
	@DisplayName("Unit:given a exists date time then return best price")
	void testOK() throws ParseDateException {
		//given
		Long PARSED_DATE_TIME = parseDateToLong("2020-06-16-10.00.00");
		when(priceService.findWithPeriodTime(PARSED_DATE_TIME, BRAND_ID, PRODUCT_ID))
			.thenReturn(buildPriceWithDateTime(PARSED_DATE_TIME, PRICE));

		//when
		Price result = priceService.findWithPeriodTime(PARSED_DATE_TIME, BRAND_ID, PRODUCT_ID);

		//then
		assertEquals(result.getPrice(), PRICE);

	}

}
