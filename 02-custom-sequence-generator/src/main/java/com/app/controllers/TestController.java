package com.app.controllers;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Address;
import com.app.entities.Student;
import com.app.repositories.AddressRepository;
import com.app.repositories.StudentRepository;

@RestController
@RequestMapping("/test")
public class TestController {
	private Logger logger = Logger.getLogger(getClass().getName());
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private AddressRepository addressRepo;
	
	@GetMapping("/test")
	public ResponseEntity<Student> create(){
		Address address = new Address("Chennai","Tamil Nadu");
		address = addressRepo.save(address);
		Student student = new Student("Chanjay", 26, address);
		student = studentRepo.save(student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
}
