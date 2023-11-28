package com.app.example.sample_repo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.example.sample_repo.entity.Student;
import com.app.example.sample_repo.service.StudentService;

import lombok.Delegate;

@RestController
@RequestMapping("/v1")
public class StudentCtrl {

	@Autowired
	StudentService impl;

	@GetMapping(value = "/student")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> studentsList = impl.getAllStudents();
		return new ResponseEntity<>(studentsList, HttpStatus.OK);
	}

	@GetMapping(value = "/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student student = impl.getStudetById(id);
		if (student != null) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/student")
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		int id = student.getId();
		student = impl.createStudent(student);
		if (student != null) {
			return new ResponseEntity<>(student, HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Student with id : " + id + " is already present", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(value = "/student/{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody Student student) {
		student = impl.updateStudetById(id, student);
		if (student != null) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "/student/{id}")
	public ResponseEntity<Object> deleteStudentById(@PathVariable int id) {
		impl.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
