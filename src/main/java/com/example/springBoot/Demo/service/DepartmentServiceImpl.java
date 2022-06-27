package com.example.springBoot.Demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBoot.Demo.entity.Department;
import com.example.springBoot.Demo.error.DepartmentNotFoundException;
import com.example.springBoot.Demo.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository depRepo;
	
	@Override
	public Department saveDepartment(Department department) {
		return depRepo.save(department);
	}
	
	@Override
	public List<Department> fetchDepartmentList(){
		return depRepo.findAll();
	}

	@Override
	public Department fetchDepById(Long depId) throws DepartmentNotFoundException {
		Optional<Department> department = depRepo.findById(depId);
		
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department not found");
		}
		
		return department.get();
	}

	@Override
	public void deleteDepById(Long depId) {
		depRepo.deleteById(depId);
	}

	@Override
	public Department updateDep(Long depId, Department department) {
		
		Department depDB = depRepo.findById(depId).get();
		
		if(Objects.nonNull(department.getDepName()) &&
				!"".equalsIgnoreCase(department.getDepName())) {
			depDB.setDepName(department.getDepName());
		}
		
		if(Objects.nonNull(department.getDepAddress()) &&
				!"".equalsIgnoreCase(department.getDepAddress())) {
			depDB.setDepAddress(department.getDepAddress());
		}
		
		if(Objects.nonNull(department.getDepCode()) &&
				!"".equalsIgnoreCase(department.getDepCode())) {
			depDB.setDepCode(department.getDepCode());
		}
		
		return depRepo.save(depDB);
		
	}

	@Override
	public Department fetchDepByName(String depName) {
		return depRepo.findByDepNameIgnoreCase(depName);
	}
	

	
}
