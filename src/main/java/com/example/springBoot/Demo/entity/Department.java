package com.example.springBoot.Demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Department")
public class Department {
	
	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	private long depId;
	
	@NotBlank(message = "Add Department Name")
	private String depName;
	
	private String depAddress;
	private String depCode;
	
	
	
}
