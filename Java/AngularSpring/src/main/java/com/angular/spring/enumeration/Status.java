package com.angular.spring.enumeration;

public enum Status {

	SERVER_UP("SERVER_UP"),
	SERVER_DOWN("SERVER_DOWN");
	
	Status(String status) {
		this.status=status;
	}

	private final String status;
	
	public String getStatus() {
		return this.status;
	}
	
	
}
