package edu.poly.asm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import edu.poly.asm.config.StorageProperties;
import edu.poly.asm.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (arg->{
			storageService.init();
		});
	}
}
