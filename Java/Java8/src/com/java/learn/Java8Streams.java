package com.java.learn;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Java8Streams {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(4);
		a.add(3);
		a.add(8);
		a.add(12);
		a.forEach(n -> {
			System.out.println(n);
		});

		// System.out.println("Foreach");
		
		System.out.println();

		/*
		 * a.stream().map(num->{ System.out.println("In map"); return num*100;
		 * }).forEach(newNum ->{System.out.println(newNum);});
		 */

		ArrayList<Person> persons = new ArrayList<Person>();

		persons.add(new Person(10, "Name 1"));
		persons.add(new Person(22, "Name 1"));
		persons.add(new Person(110, "Name 1"));
		persons.add(new Person(35, "Name 1"));
		persons.add(new Person(68, "Name 1"));
		persons.add(new Person(90, "Name 1"));

		persons.stream().filter(p -> p.getAge() > 18).collect(Collectors.toList()).forEach(b -> {
			System.out.println(b);
		});

	}

	private void privateMethod() {
		System.out.println("In Private method");
	}


}
