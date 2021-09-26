package com.exercise.dto;

import lombok.Data;

@Data
public class StudentDto {

	private int studentId;
	private String studentName;
	private Long studentContact;
	private String studentEmail;
	private int courseId;

}
