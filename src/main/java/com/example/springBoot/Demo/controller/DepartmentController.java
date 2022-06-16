package com.example.springBoot.Demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.Demo.entity.Department;
import com.example.springBoot.Demo.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService depService;
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
	
		return depService.saveDepartment(department);
		
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		return depService.fetchDepartmentList();
	}

	@GetMapping("/departments/{id}")
	public Department fetchDepById(@PathVariable("id") Long depId) {
		return depService.fetchDepById(depId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepById(@PathVariable("id") Long depId) {
		depService.deleteDepById(depId);
		return "Dep "+depId+" deleted!";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDep(@PathVariable("id") Long depId,
			@RequestBody Department department) {
		return depService.updateDep(depId, department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepByName(@PathVariable("name") String depName) {
		return depService.fetchDepByName(depName);
	}
}