package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("fakeDao")
public class FakePersonDAO implements PersonDAO{
	
	ArrayList<Person> personList = new ArrayList<Person>();

	@Override
	public int insertPerson(Person p) {
		personList.add(p);
		return 1;
	}

	@Override
	public ArrayList<Person> getAllpersons() {
		
		return personList;
	}

}
