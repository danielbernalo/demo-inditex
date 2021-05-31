package com.bernal.inditex.prices.worker.jobs;

import com.bernal.inditex.prices.worker.services.LoaderPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class WorkerRunner implements CommandLineRunner {

	@Autowired
	LoaderPricesService loaderPricesService;

	@Override
	public void run(String... args) throws Exception {
		loaderPricesService.load();
	}
}
