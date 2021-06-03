package com.bernal.inditex.prices.worker;


import com.bernal.inditex.prices.worker.domain.errors.MissingFilePathException;
import com.bernal.inditex.prices.worker.service.LoaderPrices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bernal.inditex")
@Slf4j
public class WorkerApplication implements CommandLineRunner {

	@Autowired
	LoaderPrices loaderPrices;

	public static void main(String[] args) {
		SpringApplication.run(WorkerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			loaderPrices.load();
		} catch (MissingFilePathException e) {
			log.error("Please check args index (0) is file name", e);
		}
	}
}
