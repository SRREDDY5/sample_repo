package com.app.example.sample_repo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.example.sample_repo.entity.Student;

@Service
public class StudentServiceImpl {

	List<Student> students = new ArrayList<>();

	public List<Student> getAllStudents() {
		return students;
	}

	public Student getStudetById(int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}

	public Student createStudent(Student student) {
		Student student2 = getStudetById(student.getId());
		if (student2 == null) {
			students.add(student);
			return student;
		}
		return null;
	}
}
