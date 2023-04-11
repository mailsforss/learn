package com.angular.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

}
