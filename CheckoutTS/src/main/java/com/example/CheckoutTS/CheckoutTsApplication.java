package com.example.CheckoutTS;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
@SpringBootApplication
//public class CheckoutTsApplication implements CommandLineRunner{
	public class CheckoutTsApplication {
@Autowired

	public static void main(String[] args) {
		SpringApplication.run(CheckoutTsApplication.class, args);
	}
	/*@Override
	public void run(String... args) throws Exception {
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS CheckOut (id VARCHAR NOT NULL, clientId INT, date date,direction VARCHAR,products VARCHAR,PRIMARY KEY (id));");

	}*/

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


}
