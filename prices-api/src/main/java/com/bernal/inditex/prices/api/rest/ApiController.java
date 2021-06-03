package com.bernal.inditex.prices.api.rest;

import static com.bernal.inditex.domain.converters.Utils.parseDate;

import com.bernal.inditex.domain.entity.Price;
import com.bernal.inditex.domain.errors.ParseDateException;
import com.bernal.inditex.domain.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan("com.bernal.inditex.domain")

public class ApiController {

	public static void main(String[] args) {
		SpringApplication.run(ApiController.class);
	}

	@Autowired
	private PriceService pricesService;

	@RequestMapping(value = "/price", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Price listPrices(@RequestParam(value = "current_date") String date,
		@RequestParam(value = "brand") Long brandId, @RequestParam(value = "product") Long productId)
		throws ParseDateException {
		return pricesService.findWithPeriodTime(
			parseDate(date),
			brandId,
			productId);
	}
}
