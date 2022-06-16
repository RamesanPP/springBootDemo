package com.example.springBoot.Demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBoot.Demo.entity.Department;
import com.example.springBoot.Demo.repository.DepartmentRepo;


@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepo depRepo;
	
	@Override
	public Department saveDepartment(Department department) {
		return depRepo.saveAndFlush(department);
	}
	
	@Override
	public List<Department> fetchDepartmentList(){
		return depRepo.findAll();
	}
}
