package com.bernal.inditex.prices.api.rest;

import static com.bernal.inditex.domain.converters.Utils.parseDateToLong;

import com.bernal.inditex.domain.errors.ParseDateException;
import com.bernal.inditex.domain.service.PriceService;
import com.bernal.inditex.prices.api.rest.com.bernal.inditex.prices.api.domain.PriceDTO;
import com.bernal.inditex.prices.api.rest.com.bernal.inditex.prices.api.domain.converters.PriceToPriceDTO;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ApiController {

	@Autowired
	private PriceToPriceDTO priceToPriceDTO;
	@Autowired
	private PriceService pricesService;

	public static void main(String[] args) {
		SpringApplication.run(ApiController.class);
	}

	@RequestMapping(value = "/price", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<PriceDTO> listPrices(@RequestParam(value = "current_date") String date,
		@RequestParam(value = "brand") Long brandId, @RequestParam(value = "product") Long productId)
		throws ParseDateException {
		return Stream.of(pricesService.findWithPeriodTime(
			parseDateToLong(date),
			brandId,
			productId)).map(price -> {
			try {
				return priceToPriceDTO.transform(price);
			} catch (ParseDateException e) {
				log.error("Invalid Long Date, please check date entity", e);
			}
			return null;
		}).findFirst();
	}
}
