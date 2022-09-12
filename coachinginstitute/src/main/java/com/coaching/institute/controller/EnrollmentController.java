package com.coaching.institute.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.coaching.institute.model.Enrollment;
import com.coaching.institute.service.EnrollmentService;

@RestController
public class EnrollmentController {
	
	@Autowired
	private  EnrollmentService enrollmentService;
	
	@PostMapping("/saveEnrollment")
	public Enrollment saveEnrollment_No(@RequestBody Enrollment enrollment) 
	{
		return enrollmentService.saveEnrollmen_No(enrollment);
	}
	
   @GetMapping("/getEnrollmentNo/{id}")
   public Optional<Enrollment> getEnrollmentNoByid(@PathVariable Integer id)
   {
	   return enrollmentService.getEnrollmentNoByid(id);
   }
   
   
   
//     @GetMapping("/getEnrollmentNoByStudent/{id}")
//     public Optional<Enrollment> getEnrollmentNoByStudentid(Integer id)
//   {
//	   return enrollmentService.getEnrollmentNoByStudentid(id);
//   }
   
   

}
