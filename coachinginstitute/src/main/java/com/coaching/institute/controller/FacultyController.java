package com.coaching.institute.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coaching.institute.model.Faculty;
import com.coaching.institute.model.Student;
import com.coaching.institute.service.FacultyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@PostMapping("/saveFaculty")
	public Faculty saveFaculty(@RequestBody  Faculty faculty)
	{
		log.info("Inside the FacultyController in create Faculty");
		return facultyService.saveFaculty(faculty);
	}
	
	@GetMapping("/getFaculty/{id}")
	public Optional<Faculty> getFacultyByid(@PathVariable Integer id)
	{
		log.info("Inside the FacultyController in getFacultyByid()");
		return facultyService.getFacultyByid(id);
	}
	
	@GetMapping("/getAllFaculty")
	public List<Faculty> getAllFaculty()
	{
		log.info("Inside the FacultyController in getAllFaculty()");
		return facultyService.getAllFaculty();
	}
	
	@PutMapping("/updateFaculty/{id}")
	public String updateFaculty(@PathVariable Integer id,@RequestBody Faculty faculty) 
	{
		log.info("Inside the FacultyController in updateFaculty");
		return facultyService.updateFaculty(id, faculty);
	}
	
	@DeleteMapping("/deleteFaculty/{id}")
	public String deleteFaculty(@PathVariable Integer id) 
	{
		log.info("Inside the FacultyController in deleteFaculty()");
		return facultyService.deleteFaculty(id);
	}
	
	@GetMapping("/getAllStudentByFaculty/{id}")
	public List<Student> getAllStudentByid(@PathVariable Integer id)
	{
		log.info(" Inside the FacultyController in getAllStudentByFaculty");
		return facultyService.getAllStudentByid(id);
	}
	
	
  
	
   

}
