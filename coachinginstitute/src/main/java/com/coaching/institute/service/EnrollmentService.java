package com.coaching.institute.service;

import java.util.Optional;

import com.coaching.institute.model.Enrollment;

public interface EnrollmentService {
	
	Enrollment saveEnrollmen_No(Enrollment  enrollment);
	
	Optional<Enrollment> getEnrollmentNoByid(Integer id);
	
	//Optional<Enrollment> getEnrollmentNoByStudentid(Integer id);
	

}
