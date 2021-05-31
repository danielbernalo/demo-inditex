package com.bernal.inditex.prices.worker.config;

import com.bernal.inditex.prices.worker.domain.errors.MissingFilePathException;
import com.bernal.inditex.prices.worker.ingestion.reader.PriceCsvReader;
import com.bernal.inditex.prices.worker.services.FileLoadPricesService;
import com.bernal.inditex.prices.worker.services.LoaderPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Autowired
	private ApplicationArguments args;

	@Bean
	public LoaderPricesService loaderPricesService() throws MissingFilePathException {
		verifyArguments();
		PriceCsvReader priceCsvReader = new PriceCsvReader(args);
		return new FileLoadPricesService(priceCsvReader);
	}

	public void verifyArguments() throws MissingFilePathException {
		if (args.getNonOptionArgs().size() == 0) {
			throw new MissingFilePathException();
		}
	}
}
