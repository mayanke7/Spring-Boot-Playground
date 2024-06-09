package com.mayanke7.DBConnection;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DbConnectionApplication  implements CommandLineRunner {
	private final DataSource dataSource;
	private final JdbcTemplate jdbcTemplate;
	public DbConnectionApplication(final DataSource dataSource){
		this.dataSource= dataSource;
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}

	public static void main(String[] args) {
		SpringApplication.run(DbConnectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Datasource "+ dataSource.toString());
		jdbcTemplate.execute("select 1");
	}
}
