package com.knits.spring.mydemo.dao;

import java.util.List;

import com.knits.spring.mydemo.model.Person;



public interface PersonDao {
	
	List<Person> readPersons();

}
