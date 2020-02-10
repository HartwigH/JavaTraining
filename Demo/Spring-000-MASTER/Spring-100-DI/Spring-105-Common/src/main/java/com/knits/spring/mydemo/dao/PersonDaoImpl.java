package com.knits.spring.mydemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.knits.spring.mydemo.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Override
	public List<Person> readPersons() {
		// TODO Auto-generated method stub
		Person person1 = new Person();
		person1.setAge(18);
		person1.setName("Galahad");
		
		Person person2 = new Person();
		person2.setAge(25);
		person2.setName("Ludwig");
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		return persons;
	}

	
}
