package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;

@Service
public class PersonService {
	
	private final PersonDAO personDAO;
	
	@Autowired
	public PersonService(@Qualifier("fakeDao") PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	public void addPerson(Person person) {
		personDAO.insertPerson(person);
	}
	
	public ArrayList<Person> getAllPersons(){
		return personDAO.getAllpersons();
	}

}
