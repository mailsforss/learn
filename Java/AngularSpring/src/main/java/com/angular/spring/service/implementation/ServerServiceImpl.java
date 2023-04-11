package com.angular.spring.service.implementation;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Random;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.angular.spring.enumeration.Status;
import com.angular.spring.model.Server;
import com.angular.spring.repo.ServerRepo;
import com.angular.spring.service.ServerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {

	private final ServerRepo serverRepo;

	@Override
	public Server createServer(Server server) {
		log.info("Creating server with name:{}", server.getName());

		server.setImageUrl(setServerImageURL());

		return serverRepo.save(server);
	}

	private String setServerImageURL() {
		String serverImg[] = { "image1.png", "image2.png", "image3.png", "image4.png" };

		return ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/server/image/" + serverImg[new Random().nextInt(4)]).toUriString();
	}

	@Override
	public Collection<Server> list(int limit) {
		log.info("Fetching all servers ");

		return serverRepo.findAll(PageRequest.of(0, limit)).toList();
	}

	@Override
	public Server get(Long id) {
		log.info("Fetching  server by id {}:", id);
		return serverRepo.findById(id).get();
	}
	
	/**
	 * This method updates the server 
	 */

	@Override
	public Server update(Server server) {
		log.info("Updating  server  {}:", server.getName());
		return serverRepo.save(server);
	}

	@Override
	public Boolean delete(Long id) {
		log.info("Deleting  server  {}:", id);
		serverRepo.deleteById(id);
		return Boolean.TRUE;
	}

	@Override
	public Server ping(String ipAddr) {

		log.info("pinging server with IP:{}", ipAddr);

		Server server = serverRepo.findByIpAddress(ipAddr);
		try {
			InetAddress address = InetAddress.getByName(ipAddr);
			server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
			serverRepo.save(server);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return server;
	}

}
