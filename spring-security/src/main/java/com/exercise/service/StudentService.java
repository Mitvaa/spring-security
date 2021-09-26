package com.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import static com.exercise.util.CommonConstants.*;

import java.util.List;

import com.exercise.dto.StudentDto;
import com.exercise.model.Course;
import com.exercise.model.Student;
import com.exercise.repository.CourseRepository;
import com.exercise.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	public String addStudent(StudentDto studentDto) {
		try {
			studentRepo.save(dtoToModel(studentDto));
			return SUCCESS;
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}
	public String updateStudent(StudentDto studentDto) {
		try {
			studentRepo.save(dtoToModel(studentDto));
			return SUCCESS;
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}
	
	public String deleteStudent(int id) {
		try {
		studentRepo.deleteById(id);
		return "success";
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

	public Student dtoToModel(StudentDto studentDto) {
		Student student=new Student();
		student.setCourse(courseRepo.findById(studentDto.getCourseId()).get());
		student.setStudentContact(studentDto.getStudentContact());
		student.setStudentEmail(studentDto.getStudentEmail());
		student.setStudentId(studentDto.getStudentId());
		student.setStudentName(studentDto.getStudentName());
		return student;
	}
	
	public List<Student> getStudentsByName(String studentName) {
		try {
			List<Student> students=studentRepo.findByStudentName(studentName);
			return students;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Student getStudentByEmail(String studentEmail) {
		try {
			Student students=studentRepo.findByStudentEmail(studentEmail);
			return students;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Student getStudentByContactNo(Long studentContact) {
		try {
			Student students=studentRepo.findByStudentContact(studentContact);
			return students;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Student> getStudentByCourses(int course) {
		try {
			Course courseObj=courseRepo.findById(course).get();
			List<Student> students=studentRepo.findByCourse(courseObj);
			return students;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Student> getAllPaginatedStudnet( int pageNo , int pageSize ) {
		try {
			Pageable paging = PageRequest.of(pageNo, pageSize);
			Page<Student> pagedResult = studentRepo.findAll(paging);
			
			return pagedResult.toList();
		} catch (Exception e) {
			return null;
		}
		
		
	}
}
