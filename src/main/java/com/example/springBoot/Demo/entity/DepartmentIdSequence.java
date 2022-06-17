package com.example.springBoot.Demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "user_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentIdSequence {

	@Id
	private String id;
	private int seqNo;
	
}
