package com.coaching.institute.service;

import java.util.List;
import java.util.Optional;

import com.coaching.institute.model.Faculty;
import com.coaching.institute.model.Student;

public interface FacultyService {
  
	Faculty saveFaculty(Faculty faculty);
	
    Optional<Faculty> getFacultyByid (Integer id);
	
	List<Faculty> getAllFaculty();
	
    String updateFaculty(Integer id, Faculty faculty);
	
	String deleteFaculty(Integer id);
	
	List<Student> getAllStudentByid(Integer id);

}
