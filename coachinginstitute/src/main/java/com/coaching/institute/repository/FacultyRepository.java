package com.coaching.institute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coaching.institute.model.Faculty;
import com.coaching.institute.model.Student;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	//List<Student> findAllStudentByid(Integer id);
	
}
