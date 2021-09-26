package com.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.model.Course;
import com.exercise.service.CourseService;
import com.exercise.util.CommonConstants;
import com.exercise.util.SpringUtil;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/")
public class CourseController {
	
	@Autowired
	CourseService service;
	
	@PostMapping("add-course")
	public ResponseEntity<String> addCourse(@RequestBody Course course) {
		log.info(" inside addCourse, adding object");
		String response = service.addCourse(course);
		return new ResponseEntity<>(response,
				response.equals(CommonConstants.SUCCESS) ? HttpStatus.OK : HttpStatus.EXPECTATION_FAILED);
	}
	
	@GetMapping("get-unique-course")
    public ResponseEntity<?> getUniqueCourse() {
		List<?> courses =  service.getUniqueCourse();
		return new ResponseEntity<>(courses,
				SpringUtil.isObjectValid(courses) ? HttpStatus.OK : HttpStatus.EXPECTATION_FAILED);
	}
	
	@GetMapping()
	public String hello() {
		return "hi mitva";
	}

}
