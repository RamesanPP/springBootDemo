package com.example.springBoot.Demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.springBoot.Demo.entity.Department;
import com.example.springBoot.Demo.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DepartmentService depService;

	private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .depAddress("Ahmedabad")
                .depCode("IT-06")
                .depName("IT")
                .depId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .depAddress("Ahmedabad")
                .depCode("IT-06")
                .depName("IT")
                .build();

        Mockito.when(depService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/departments")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "\t\"depName\":\"IT\",\n" +
                "\t\"depAddress\":\"Ahmedabad\",\n" +
                "\t\"depCode\":\"IT-06\"\n" +
                "}"))
                .andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(depService.fetchDepById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.depName").
                value(department.getDepName()));
    }
	
}