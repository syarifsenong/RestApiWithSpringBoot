package com.syarif.springbootjar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.syarif.entity")
@ComponentScan("com.syarif")
@EnableJpaRepositories("com.syarif.repository")
public class SpringbootjarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjarApplication.class, args);
		System.out.println("Hello World");
		System.out.println("Nama saya Syarif");
		System.out.println("Saya sedang belajar Rest API dengan Springboot");
	}

}
