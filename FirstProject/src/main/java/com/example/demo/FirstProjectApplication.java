package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		//spring container inside which spring create bean object for us
		ConfigurableApplicationContext context = SpringApplication.run(FirstProjectApplication.class, args);
		System.out.println("Hello World!!");
		//Alien a = new Alien();
		Alien a = context.getBean(Alien.class);
		a.show();
	}

}
