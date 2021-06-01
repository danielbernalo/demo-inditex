package com.bernal.inditex.prices.worker;

import com.bernal.inditex.prices.worker.jobs.WorkerRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.bernal.inditex.prices.domain.repository")
@EntityScan("com.bernal.inditex.prices.domain.entity")
public class WorkerApplication {

	@Bean
	public CommandLineRunner applicationRunner() {
		return new WorkerRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(WorkerApplication.class, args);
	}

}
