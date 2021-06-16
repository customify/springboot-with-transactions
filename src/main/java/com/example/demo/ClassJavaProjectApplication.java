package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class ClassJavaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassJavaProjectApplication.class, args);
	}

	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("\n################### APPLICATION STARTING NOW " + LocalDateTime.now().toString()
					+ "########################\n");
			String[] beans = ctx.getBeanDefinitionNames();
			Arrays.sort(beans);
			int number = 1;
			for (String been : beans) {
				System.out.println(number + " . " + been);
				number++;
			}
			System.out.println("Any class not listed above will not be used as a valid injectable spring bean");
		};
	}
}
