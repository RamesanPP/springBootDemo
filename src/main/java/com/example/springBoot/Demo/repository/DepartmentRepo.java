package com.example.springBoot.Demo.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.springBoot.Demo.entity.Department;

@Repository
public interface DepartmentRepo extends MongoRepository<Department, Long>{
	
	public Department findByDepName(String depName);
	
	public Department findByDepNameIgnoreCase(String depName);
	
}
