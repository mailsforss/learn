package com.angular.spring;


import org.springframework.web.filter.*;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.*;
import com.angular.spring.enumeration.Status;
import com.angular.spring.model.Server;
import com.angular.spring.repo.ServerRepo;

@SpringBootApplication
public class AngularSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularSpringApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner run(ServerRepo serverRepo) {
		return args -> {
						
			serverRepo.save( new Server(null,"0.0.0.1","Server1","8 GB","Personal PC1","http://localhost:8080/server/image/server1.png",Status.SERVER_UP));
			serverRepo.save( new Server(null,"0.0.0.2","Server2","80 GB","Personal PC2","http://localhost:8080/server/image/server2.png",Status.SERVER_UP));
			serverRepo.save( new Server(null,"0.0.0.3","Server3","64 GB","Personal PC3","http://localhost:8080/server/image/server3.png",Status.SERVER_UP));
			serverRepo.save( new Server(null,"0.0.0.4","Server4","16 GB","Personal PC4","http://localhost:8080/server/image/server4.png",Status.SERVER_UP));
		};
	}
	
	
	@Bean
	public CorsFilter corsFiler() {
		UrlBasedCorsConfigurationSource cors = new UrlBasedCorsConfigurationSource();
		
		CorsConfiguration conf= new CorsConfiguration();
		conf.setAllowCredentials(true);
		conf.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
				"Access-Type","Jwt-Token","Authorization","Origin, Accept","X-Requested-With",
				"Access-Control-Request-Method","Access-Control-Request-Header"
				));
		
		conf.setAllowedOrigins(Arrays.asList("http://localhost:3000","http://localhost:4200"));
		
		conf.setExposedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
				"Access-Type","Jwt-Token","Authorization","Origin", "Accept","X-Requested-With",
				"Access-Control-Allow-Origin","Access-Control-Allow-Credentials","Filename"
				));
		conf.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		cors.registerCorsConfiguration("/**", conf);
		return new CorsFilter(cors);
		
		
	}

}
