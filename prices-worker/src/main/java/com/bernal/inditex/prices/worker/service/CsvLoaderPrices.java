package com.bernal.inditex.prices.worker.service;

import com.bernal.inditex.domain.entity.Price;
import com.bernal.inditex.domain.service.PriceService;
import com.bernal.inditex.prices.worker.domain.errors.MissingFilePathException;
import com.bernal.inditex.prices.worker.ingestion.readers.CsvReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CsvLoaderPrices implements LoaderPrices {

	@Autowired
	CsvReader<Price> csvReader;

	@Autowired
	PriceService priceService;

	@Override
	public void load() throws MissingFilePathException {
		csvReader.read().stream().forEach(item -> {
			log.info("Cargango {}", item.toString());
			priceService.save(item);
		});
	}
}
