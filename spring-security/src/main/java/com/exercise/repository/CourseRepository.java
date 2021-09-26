package com.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exercise.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	@Query(value = "SELECT DISTINCT c.course_name FROM course_table c" , nativeQuery = true)
	public List<Course> findDistinctCourses();

}
