package com.boldseas.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class Application {

	public static void main(String[] args) {
//		System.out.println(System.getProperty("java.io.tmpdir"));
		SpringApplication.run(Application.class, args);
	}
}
