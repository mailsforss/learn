package com.example.demo.dao;

import java.util.ArrayList;
import java.util.UUID;

import com.example.demo.model.Person;

public interface PersonDAO {

	int insertPerson(Person p);
	
	default int addPerson(Person p) {
		UUID id = UUID.randomUUID();
		p.setId(id);
		return insertPerson(p);
	}
	
	public ArrayList<Person> getAllpersons();
}
