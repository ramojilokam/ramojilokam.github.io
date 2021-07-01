package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.boot.model.EmployeeDetails;

@RepositoryRestResource(collectionResourceRel="employees",path="employees")
public interface EmployeeRepo extends JpaRepository<EmployeeDetails, Long> {

	
	
	
}
