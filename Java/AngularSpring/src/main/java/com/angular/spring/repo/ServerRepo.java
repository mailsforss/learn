package com.angular.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angular.spring.model.Server;

public interface ServerRepo extends JpaRepository<Server,Long>{
	
	Server findByIpAddress(String ipAddress);

}
