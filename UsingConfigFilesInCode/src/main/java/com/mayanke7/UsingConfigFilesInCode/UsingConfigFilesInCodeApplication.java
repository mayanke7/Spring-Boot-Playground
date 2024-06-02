package com.mayanke7.UsingConfigFilesInCode;

import com.mayanke7.UsingConfigFilesInCode.config.PizzaConfig;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class UsingConfigFilesInCodeApplication implements CommandLineRunner {


	private PizzaConfig pizzaConfig;

	public  UsingConfigFilesInCodeApplication(PizzaConfig pizzaConfig){
		this.pizzaConfig= pizzaConfig;
	}
	public static void main(String[] args) {
		SpringApplication.run(UsingConfigFilesInCodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("I want pizza with sauce= "+this.pizzaConfig.getSauce()
		+" and with toppings= "+ this.pizzaConfig.getToppings()
		+" and with curst= "+ this.pizzaConfig.getCrust());
	}
}
