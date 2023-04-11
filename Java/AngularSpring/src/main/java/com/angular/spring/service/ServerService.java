package com.angular.spring.service;

import java.util.Collection;

import com.angular.spring.model.Server;

public interface ServerService {
	
	Server createServer(Server server);
	Collection<Server> list(int limit);
	Server get(Long id);
	Server update(Server server);
	Boolean delete(Long id);
	Server ping(String ipAddr);

}
