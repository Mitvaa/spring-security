package com.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import static com.exercise.util.CommonConstants.*;

import java.util.List;

import org.springframework.stereotype.Service;
import com.exercise.model.Course;
import com.exercise.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public String addCourse(Course course) {
		try {
			courseRepository.save(course);
			return SUCCESS;
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}
	
	public List<Course> getUniqueCourse() {
		try {
			List<Course> courses = courseRepository.findDistinctCourses();
			return courses;
		} catch (Exception e) {
			return null;
		}
	}

}
