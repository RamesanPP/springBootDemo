package com.example.springBoot.Demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.springBoot.Demo.entity.Department;
import com.example.springBoot.Demo.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository depRepo;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                .depName("IT")
                .depAddress("Ahmedabad")
                .depCode("IT-06")
                .depId(1L)
                .build();

        Mockito.when(depRepo.findByDepNameIgnoreCase("IT"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found =
                departmentService.fetchDepByName(departmentName);

        assertEquals(departmentName, found.getDepName());
    }
}