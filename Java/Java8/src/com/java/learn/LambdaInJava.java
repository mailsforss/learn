package com.java.learn;

public class LambdaInJava {

	public static void main(String[] args) {
		
		Calculator addition = (a,b)-> a+b;
		
		Calculator subtraction = (a,b)-> a-b;
		
		System.out.println("Addition lambda:"+addition.calculate(2, 3));
		
		System.out.println("subtraction lambda:"+subtraction.calculate(12, 3));

	}
	
	@FunctionalInterface
	interface Calculator{
		int calculate(int a, int b);
	}

}
