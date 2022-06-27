package com.example.springBoot.Demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.example.springBoot.Demo.entity.Department;

@DataMongoTest
class DepartmentRepositoryTest {
	
	@Autowired
    private DepartmentRepository depRepo;

    @BeforeEach
    void setUp() {
//        Department department =
//                Department.builder()
//                .depName("Mechanical Engineering")
//                .depCode("ME - 011")
//                .depAddress("Delhi")
//                .depId(3L)
//                .build();
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = depRepo.findById(1L).get();
        assertEquals(department.getDepName(), "CL");
    }
}