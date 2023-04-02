package com.java.learn;

public class Java8MethodReference {

	public static void main(String[] args) {
		// Use a method reference to reference the static method
		IntPredicate p = Java8MethodReference::isSumEven;
		// Call the method through the functional interface
		System.out.println("Static Method reference:"+p.test(2, 3)); // false
		System.out.println("Static Method reference:"+p.test(2, 2)); // true
		
		   // Create an instance of the class
	   
		StringUtils utils = new Java8MethodReference().new StringUtils();
		StringLength lengthFunc = utils::someMethodName1;
	    // Call the method through the functional interface
	    System.out.println("Instance Method reference:"+lengthFunc.getLength("Saravanan ")); // 5

	}
	
	
	// Define a functional interface that takes two integers and returns a boolean
	interface IntPredicate {
	    boolean test(int a, int b);
	}

	// Define a static method that checks if the sum of two integers is even

	    public static boolean isSumEven(int a, int b) {
	        return (a + b) % 2 == 0;
	    }
	
	    
	 // Define a functional interface that takes a string and returns its length
	    interface StringLength {
	        int getLength(String s);
	    }

	    // Define a class with an instance method that returns the length of a string
	    class StringUtils {    	
	    	
	        public int someMethodName(String s) {
	        	System.out.println("Some method name");
	            return s.length();
	        }
	        
	        public int someMethodName1(String s) {
	        	System.out.println("Some method name1");
	            return s.length();
	        }
	    }

	 


}
