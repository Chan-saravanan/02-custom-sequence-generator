package com.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.app.entities.Address;

public interface AddressRepository extends CrudRepository<Address, String>{
	
}
