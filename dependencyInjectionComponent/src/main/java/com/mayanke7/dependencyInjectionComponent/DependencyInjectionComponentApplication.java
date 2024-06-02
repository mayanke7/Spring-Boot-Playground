package com.mayanke7.dependencyInjectionComponent;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Log
public class DependencyInjectionComponentApplication implements CommandLineRunner {
	private final ColorPrinter colorPrinter;

	public DependencyInjectionComponentApplication(ColorPrinter colorPrinter){
		this.colorPrinter= colorPrinter;
	}


	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionComponentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(colorPrinter.print());
	}
}
