package com.app.example.sample_repo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.example.sample_repo.entity.Student;

public interface StudentDAO extends JpaRepository<Student, Integer> {

}
