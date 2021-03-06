package com.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String>{
	
}
