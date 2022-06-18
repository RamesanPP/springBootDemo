package com.example.springBoot.Demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.Demo.entity.Department;
import com.example.springBoot.Demo.error.DepartmentNotFoundException;
import com.example.springBoot.Demo.service.DepartmentService;
import com.example.springBoot.Demo.service.SequenceGeneratorService;

@RestController
//@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	private DepartmentService depService;
	
	@Autowired
	private SequenceGeneratorService seqGenService;
	
	private final Logger logr = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		logr.info("Inside saveDepartment of DepartmentController");
		department.setDepId(seqGenService.getSequenceNumber(Department.SEQUENCE_NAME));
		return depService.saveDepartment(department);
		
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		logr.info("Inside fetchDepartmentList of DepartmentController");
		return depService.fetchDepartmentList();
	}

	@GetMapping("/departments/{id}")
	public Department fetchDepById(@PathVariable("id") Long depId) throws DepartmentNotFoundException {
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
