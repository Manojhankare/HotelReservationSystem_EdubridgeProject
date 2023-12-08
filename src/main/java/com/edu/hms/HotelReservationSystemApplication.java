package com.edu.hms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HotelReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelReservationSystemApplication.class, args);
	}
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer()
//	{
//	   String[] allowDomains = new String[2];
//	   allowDomains[0] = "http://192.168.0.118:4200";
//	   allowDomains[1] = "http://localhost:8990";
//
//	   System.out.println("CORS configuration....");
//	   return new WebMvcConfigurer() {
//	      @Override
//	      public void addCorsMappings(CorsRegistry registry) {
//	         registry.addMapping("/**").allowedOrigins(allowDomains);
//	      }
//	   };
//	}

}
