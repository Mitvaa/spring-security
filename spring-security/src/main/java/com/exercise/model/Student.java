package com.exercise.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student_table")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	public int studentId;

	@Column(name = "student_name")
	public String studentName;

	@Column(name = "student_contact", length = 20, unique=true)
	public Long studentContact;

	@Column(name = "student_email", unique=true)
	public String studentEmail;
	
	@OneToOne
	@JoinColumn(name = "course_id")
	public Course course;
}
