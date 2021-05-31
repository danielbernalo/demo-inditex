package com.bernal.inditex.prices.worker.config;

import com.bernal.inditex.prices.worker.domain.errors.MissingFilePathException;
import com.bernal.inditex.prices.worker.services.FileLoadPricesService;
import com.bernal.inditex.prices.worker.services.LoaderPricesService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
@Slf4j
public class Config {

	@Autowired
	private ApplicationArguments args;

	@Bean
	public LoaderPricesService loaderPricesService() throws MissingFilePathException {
		verifyArguments();
		String filenamePath = args.getNonOptionArgs().get(0);
		return new FileLoadPricesService(filenamePath);
	}

	public void verifyArguments() throws MissingFilePathException {
		if (args.getNonOptionArgs().size() == 0) {
			throw new MissingFilePathException();
		}
	}
}
