package com.app.example.sample_repo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.example.sample_repo.dao.StudentDAO;
import com.app.example.sample_repo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	List<Student> students = new ArrayList<>();
	
	@Autowired
	private StudentDAO studentDAO;

	public List<Student> getAllStudents() {
		return studentDAO.findAll();
	}

	public Student getStudetById(int id) {
		return studentDAO.findById(id).get();
	}

	public Student createStudent(Student student) {
		return studentDAO.save(student);
	}
	
	@Override
	public Student updateStudetById(int id, Student student) {
		student.setId(id);
		return studentDAO.save(student);
	}
	
	@Override
	public void deleteStudent(int id) {
		studentDAO.deleteById(id);
	}
}
