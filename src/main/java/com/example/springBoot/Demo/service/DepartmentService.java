package com.example.springBoot.Demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springBoot.Demo.entity.Department;

@Service
public interface DepartmentService {

	public Department saveDepartment(Department department);
	
	public List<Department> fetchDepartmentList();

	public Department fetchDepById(Long depId);

	public void deleteDepById(Long depId);

	public Department updateDep(Long depId, Department department);

	public Department fetchDepByName(String depName);
	
}
