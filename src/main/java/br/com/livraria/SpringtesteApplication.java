package br.com.livraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringtesteApplication {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(SpringtesteApplication.class, args);
	}
}
