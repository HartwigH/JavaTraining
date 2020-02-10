package com.knits.spring.mydemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knits.spring.mydemo.dao.PersonDao;
import com.knits.spring.mydemo.model.Person;

import lombok.Data;

@Data
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	
	@Override
	public List<Person> findPerson() {
		// TODO Auto-generated method stub
		List<Person> personList = personDao.readPersons();
		personList.forEach(person -> System.out.println("Person: " + person));
		return personList;
	}

}
