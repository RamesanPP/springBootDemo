package com.example.springBoot.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springBoot.Demo.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long>{
	
	public Department findByDepName(String depName);
	
	public Department findByDepNameIgnoreCase(String depName);
	
}
