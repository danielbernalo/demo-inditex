package com.bernal.inditex.prices.api.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerIntegrationTest {

	private static final String BRAND_ID = "1";
	private static final String PRODUCT_ID = "35455";
	@Autowired
	MockMvc mockMvc;

	@Test
	@DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
	void test1() throws Exception {
		String CURRENT_DATE = "2020-06-14-10.00.00";
		Double RESULT_PRICE = 35.50;
		mockMvc
			.perform(
				get("/price").param("current_date", CURRENT_DATE).param("brand", BRAND_ID).param("product", PRODUCT_ID))

			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.price").value(RESULT_PRICE))
			.andReturn();

	}

	@Test
	@DisplayName(" Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
	void test2() throws Exception {
		String CURRENT_DATE = "2020-06-14-16.00.00";
		Double RESULT_PRICE = 25.45;
		mockMvc
			.perform(
				get("/price").param("current_date", CURRENT_DATE).param("brand", BRAND_ID).param("product", PRODUCT_ID))

			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.price").value(RESULT_PRICE))
			.andReturn();

	}

	@Test
	@DisplayName(" Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
	void test3() throws Exception {
		String CURRENT_DATE = "2020-06-14-21.00.00";
		Double RESULT_PRICE = 35.50;
		mockMvc
			.perform(
				get("/price")
					.param("current_date", CURRENT_DATE)
					.param("brand", BRAND_ID)
					.param("product", PRODUCT_ID)
			)

			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.price").value(RESULT_PRICE))
			.andReturn();

	}

	@Test
	@DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
	void test4() throws Exception {
		String CURRENT_DATE = "2020-06-15-10.00.00";
		Double RESULT_PRICE = 30.50;
		mockMvc
			.perform(
				get("/price")
					.param("current_date", CURRENT_DATE)
					.param("brand", BRAND_ID)
					.param("product", PRODUCT_ID)
			)

			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.price").value(RESULT_PRICE))
			.andReturn();

	}

	@Test
	@DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
	void test5() throws Exception {
		String CURRENT_DATE = "2020-06-16-21.00.00";
		Double RESULT_PRICE = 38.95;
		mockMvc
			.perform(
				get("/price")
					.param("current_date", CURRENT_DATE)
					.param("brand", BRAND_ID)
					.param("product", PRODUCT_ID)
			)

			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.price").value(RESULT_PRICE))
			.andReturn();

	}

}

