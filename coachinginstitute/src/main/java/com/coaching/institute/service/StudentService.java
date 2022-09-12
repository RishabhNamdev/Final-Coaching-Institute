package com.coaching.institute.service;

import java.util.List;
import java.util.Optional;

import com.coaching.institute.exception.CustomException;
import com.coaching.institute.exception.EmptyInputException;
import com.coaching.institute.exception.IdNotFoundException;
import com.coaching.institute.exception.StudentNotFoundException;

//import org.springframework.stereotype.Service;

import com.coaching.institute.model.Student;

public interface StudentService {

	Student saveStudent(Student student)throws CustomException;

	Optional<Student> getStudentByid(Integer id)throws CustomException;

	List<Student> getAllStudent()throws CustomException;

	String updateStudent(Integer id, Student student)throws  CustomException;

	String deleteStudent(Integer id)throws  CustomException;
	
	//List<Student> getStudentFacultyByid(Integer id);
	
	
//	List<Student> getAllStudentFacultyByid(Integer id);

	
}
