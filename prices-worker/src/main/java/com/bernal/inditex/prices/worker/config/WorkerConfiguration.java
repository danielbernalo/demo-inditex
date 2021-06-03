package com.bernal.inditex.prices.worker.config;

import com.bernal.inditex.prices.worker.ingestion.readers.PriceCsvReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerConfiguration {

	@Value("${import.csv:./data_import.csv}")
	String filePath;

	@Bean
	PriceCsvReader csvReader() {
		return new PriceCsvReader(filePath);
	}
}
