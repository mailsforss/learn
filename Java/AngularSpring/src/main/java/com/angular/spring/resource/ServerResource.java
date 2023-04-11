package com.angular.spring.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.spring.enumeration.Status;
import com.angular.spring.model.Response;
import com.angular.spring.model.Server;
import com.angular.spring.service.ServerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerResource {
	
	private final ServerService service;
	
	@GetMapping("/list")
	public ResponseEntity<Response> getServers(){
		System.out.println("Reached getServers");
		return ResponseEntity.ok(
				Response.builder()
				.time(LocalDateTime.now())
				.data(Map.of("servers",service.list(30)))
				.message("Servers retrieved")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.build()			
				);
	}
	
	@GetMapping("/ping/{ipaddr}")
	public ResponseEntity<Response> pingServer(@PathVariable("ipaddr") String ipAddr){
		
		Server server = service.ping(ipAddr);
		
		return ResponseEntity.ok(
				Response.builder()
				.time(LocalDateTime.now())
				.data(Map.of("servers",service.ping(ipAddr)))
				.message(server.getStatus() == Status.SERVER_UP?"Ping Success":"Ping Failed")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.build()			
				);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Response> saveServer(@RequestBody @Valid Server server){
		
		return ResponseEntity.ok(
				Response.builder()
				.time(LocalDateTime.now())
				.data(Map.of("server",service.createServer(server)))
				.message("Srever Created")
				.status(HttpStatus.CREATED)
				.statusCode(HttpStatus.CREATED.value())
				.build()			
				);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getServer(@PathVariable("id")Long id){
		
		return ResponseEntity.ok(
				Response.builder()
				.time(LocalDateTime.now())
				.data(Map.of("server",service.get(id)))
				.message("Srever Created")
				.status(HttpStatus.CREATED)
				.statusCode(HttpStatus.CREATED.value())
				.build()			
				);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteServer(@PathVariable("id")Long id){
		
		return ResponseEntity.ok(
				Response.builder()
				.time(LocalDateTime.now())
				.data(Map.of("deleted",service.delete(id)))
				.message("Srever Deleted")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.build()			
				);
	}
	
	
	@GetMapping(path = "/image/{filename}" , produces = MediaType.IMAGE_PNG_VALUE )
	public byte[] getImage(@PathVariable("filename")String fileName) throws IOException{
		
		return Files.readAllBytes(Paths.get("C:\\Users\\mails\\Downloads\\Images\\"+fileName))
					;
	}
	

}
