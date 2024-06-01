package com.mayanke7.dependencyInjection;

import com.mayanke7.dependencyInjection.impl.ColorPrinterImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class DependencyInjectionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionApplication.class, args);
	}

	@Override
	public void run(final String ... args){
		final ColorPrinter colorPrinter= new ColorPrinterImpl();
		log.info(colorPrinter.print());
	}

}
