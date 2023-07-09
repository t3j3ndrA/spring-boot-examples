package com.example.studentrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentrestApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(){
//		return (x)->{
//			System.out.println("Student app initialised ✅");
//		};
//	}

}
