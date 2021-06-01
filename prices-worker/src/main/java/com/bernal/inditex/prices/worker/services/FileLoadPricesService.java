package com.bernal.inditex.prices.worker.services;

import com.bernal.inditex.prices.domain.entity.Price;
import com.bernal.inditex.prices.domain.repository.PricesRepository;
import com.bernal.inditex.prices.worker.ingestion.reader.CsvReader;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FileLoadPricesService implements LoaderPricesService {

	@Autowired
	CsvReader<Price> csvReader;

	@Autowired
	PricesRepository pricesRepository;


	@Override
	public void load() {
		List<Price> csv = csvReader.read();
		pricesRepository.save(csv.get(0));
		log.info(pricesRepository.findAll().get(0).toString());
	}

}
