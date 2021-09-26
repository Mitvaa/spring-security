package com.exercise.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exercise.model.Course;
import com.exercise.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findByStudentName(String studentName);
	Student findByStudentEmail( String studentEmail );
	Student findByStudentContact( Long studentContact );
	List<Student> findByCourse( Course course );
	Page<Student> findAll(Pageable paging);
	
}
