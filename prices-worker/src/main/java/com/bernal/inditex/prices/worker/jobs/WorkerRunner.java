package com.bernal.inditex.prices.worker.jobs;

import com.bernal.inditex.prices.worker.services.LoaderPricesService;
import javax.inject.Inject;
import org.springframework.boot.CommandLineRunner;

public class WorkerRunner implements CommandLineRunner {

	@Inject
	LoaderPricesService loaderPricesService;

	@Override
	public void run(String... args) throws Exception {
		loaderPricesService.load();

	}
}
