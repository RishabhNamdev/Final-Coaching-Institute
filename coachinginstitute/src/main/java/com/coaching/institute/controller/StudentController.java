

package com.coaching.institute.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coaching.institute.model.Student;
import com.coaching.institute.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student student){
		log.info("Inside the StudentContoller in create student ");
		return studentService.saveStudent(student);
		
	}
	
	@GetMapping("/getStudent/{id}")
	public Optional<Student> getStudentByid(@ PathVariable Integer id)
	{
		log.info("Inside the StudentContoller in getStudentByid() ");
		return studentService.getStudentByid(id);
		
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent()
	{
		log.info("Inside the StudentContoller in getAllStudent()");
		return studentService.getAllStudent();
		
	}
	
	@PutMapping("/updateStudent/{id}")
	public String updateStudent( @PathVariable Integer id,@RequestBody Student student)
	{
		log.info("Inside the StudentContoller in updateStudent()");
		return studentService.updateStudent(id, student);
	//	return "Student updated Successfully";
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable  Integer id)
	{
		log.info("Inside the StudentContoller  in deleteStudentByid() ");
		return studentService.deleteStudent(id);
		
	}
	
	

}
