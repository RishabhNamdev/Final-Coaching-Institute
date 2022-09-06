package com.coaching.institute.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coaching.institute.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	//List<Student> findAllStudentFacultyByid(Integer id);
	List<Student> findAllByfacultyId(Integer id);

}
