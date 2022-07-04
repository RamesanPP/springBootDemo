package com.example.springBoot.Demo.controller;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ControllerSmokeTest {

	@Autowired
	private DepartmentController depController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(depController).isNotNull();
	}
}