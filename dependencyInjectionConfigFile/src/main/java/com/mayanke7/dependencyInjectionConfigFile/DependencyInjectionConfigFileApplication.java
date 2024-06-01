package com.mayanke7.dependencyInjectionConfigFile;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Log
public class DependencyInjectionConfigFileApplication implements CommandLineRunner {
	private final ColorPrinter colorPrinter;

	public DependencyInjectionConfigFileApplication(ColorPrinter colorPrinter){
		this.colorPrinter= colorPrinter;

	}


	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionConfigFileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(colorPrinter.print());
	}
}
