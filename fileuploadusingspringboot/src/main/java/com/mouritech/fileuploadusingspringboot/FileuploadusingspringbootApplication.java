package com.mouritech.fileuploadusingspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FileuploadusingspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileuploadusingspringbootApplication.class, args);
	}

}
