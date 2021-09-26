package com.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.exercise.util.CommonConstants.*;

import java.util.List;

import com.exercise.dto.StudentDto;
import com.exercise.model.Student;
import com.exercise.service.StudentService;
import com.exercise.util.SpringUtil;

import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("add-student")
	public ResponseEntity<String> addStudent(@RequestBody StudentDto studentDto) {
		log.info(" inside addStudent, adding object");
		String response = studentService.addStudent(studentDto);
		return new ResponseEntity<>(response,
				response.equals(SUCCESS) ? HttpStatus.OK : HttpStatus.EXPECTATION_FAILED);
	}
	
	@PatchMapping("update-student")
    public ResponseEntity<String> updateStudent(@RequestBody StudentDto studentDto) {
        log.info("inside updateStudent");
        String response = studentService.updateStudent(studentDto);
        return new ResponseEntity<>(response, response.equals(SUCCESS) ? HttpStatus.OK : HttpStatus.EXPECTATION_FAILED);
	}
	
	@DeleteMapping(value="delete-student/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {
		log.info("in deleteStudent");
		String response=studentService.deleteStudent(studentId);
		return new ResponseEntity<>(response, response.equals(SUCCESS) ? HttpStatus.OK : HttpStatus.EXPECTATION_FAILED);
	}
	
	@GetMapping("/get-all-student/{studentName}")
    public ResponseEntity<?> getStudentsByName(@PathVariable("studentName") String studentName) {
        log.info("in getStudentsByName");
        List<?> students = studentService.getStudentsByName(studentName);
        return new ResponseEntity<>(students,
				SpringUtil.isObjectValid(students) ? HttpStatus.OK : HttpStatus.EXPECTATION_FAILED);
    }
	
	@GetMapping("get-student-Email/{studentEmail}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable("studentEmail") String studentEmail) {
        //log.info("in getStudentsByName");
        Student students = studentService.getStudentByEmail(studentEmail);
        return new ResponseEntity<>(students,
				SpringUtil.isObjectValid(students) ? HttpStatus.OK : HttpStatus.EXPECTATION_FAILED);
    }
	
	@GetMapping("get-student-Contact/{studentContact}")
    public ResponseEntity<Student> getStudentByContactNo(@PathVariable("studentContact") Long studentContact) {
        //log.info("in getStudentsByName");
        Student students = studentService.getStudentByContactNo(studentContact);
        return new ResponseEntity<>(students,
				SpringUtil.isObjectValid(students) ? HttpStatus.OK : HttpStatus.EXPECTATION_FAILED);
    }
	
	@GetMapping("get-student-Course/{course}")
    public ResponseEntity<?> getStudentByCourses(@PathVariable("course") int course) {
        //log.info("in getStudentsByName");
        List<?> students = studentService.getStudentByCourses(course);
        return new ResponseEntity<>(students,
				SpringUtil.isObjectValid(students) ? HttpStatus.OK : HttpStatus.EXPECTATION_FAILED);
    }
	
	@GetMapping("get-paginated-student/{pageNo}/{pageSize}")
    public ResponseEntity<?> getAllPaginatedStudnet(@PathVariable("pageNo") int pageNo , @PathVariable("pageSize") int pageSize) {
        //log.info("in getStudentsByName");
        List<?> students = studentService.getAllPaginatedStudnet(pageNo,pageSize);
        return new ResponseEntity<>(students,
				SpringUtil.isObjectValid(students) ? HttpStatus.OK : HttpStatus.EXPECTATION_FAILED);
    }

}
