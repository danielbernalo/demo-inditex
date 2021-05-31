package com.bernal.inditex.prices.worker;

import com.bernal.inditex.prices.worker.jobs.WorkerRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkerApplication {

	@Bean
	public CommandLineRunner applicationRunner() {
		return new WorkerRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(WorkerApplication.class, args);
	}

}
