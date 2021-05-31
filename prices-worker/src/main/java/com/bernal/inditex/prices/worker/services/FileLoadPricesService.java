package com.bernal.inditex.prices.worker.services;

import com.bernal.inditex.prices.worker.domain.Price;
import com.bernal.inditex.prices.worker.ingestion.reader.CsvReader;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileLoadPricesService implements LoaderPricesService {

	private final CsvReader<Price> csvReader;

	public FileLoadPricesService(CsvReader<Price> csvReader) {
		this.csvReader = csvReader;
	}

	@Override
	public void load() {
		List<Price> csv = csvReader.read();
		log.info(csv.toString());
	}
}
