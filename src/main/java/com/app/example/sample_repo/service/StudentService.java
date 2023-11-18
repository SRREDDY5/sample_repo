package com.app.example.sample_repo.service;

import java.util.List;

import com.app.example.sample_repo.entity.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	
	public Student getStudetById(int id);
	
	public Student createStudent(Student student);
}
