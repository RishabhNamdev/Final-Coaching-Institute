package com.coaching.institute.serviceimpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.coaching.institute.exception.CustomException;
import com.coaching.institute.exception.EmptyInputException;
import com.coaching.institute.exception.IdNotFoundException;
import com.coaching.institute.exception.StudentNotFoundException;
import com.coaching.institute.model.Enrollment;
import com.coaching.institute.model.Faculty;
import com.coaching.institute.model.Student;
//import com.coaching.institute.repository.FacultyRepository;
import com.coaching.institute.repository.StudentRepository;
import com.coaching.institute.service.StudentService;

//import lombok.experimental.StandardException;
import lombok.extern.slf4j.Slf4j;

//@StandardException
@Service
@Slf4j

public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	// @Autowired
	// private FacultyRepository facultyRepo;

	@Override
	public Student saveStudent(Student student) {
		log.info("Inside the StudentServiceImpl in saveStudent()");
		if (student.getFullName().isEmpty() || student.getFullName().length() == 0) {
			throw new CustomException(601, "please sent proper name,It blank", LocalDate.now());
		}

		return studentRepo.save(student);

	}

	@Override
	public Optional<Student> getStudentByid(Integer id) {
		Optional<Student> stu = null;

		log.info("Inside the StudentServiceImpl in getStuddentByid()");
		stu = studentRepo.findById(id);
		if (stu.isPresent()) {
			log.info("Inside the StudentServiceImpl if block check the conditon");
			return stu;
		} else {
			throw new CustomException(404, "Student not found for Id:" + id, LocalDate.now());
		}

	}

	@Override
	public List<Student> getAllStudent() {

		log.info("Inside the StudentServiceImpl in getAllStudent()");
		List<Student> listofstu = studentRepo.findAll();
		if (listofstu.isEmpty()) {
			throw new CustomException(500, "list is not found id empty,we have nothing to return", LocalDate.now());
		}
		return listofstu;
//		} catch (Exception e) {
//			throw new CustomException(607,
//					"Something went wrong in Service layer while fetching all Student" + e.getMessage(),
//					LocalDate.now());
//		}

	}

	@Override
	public String updateStudent(Integer id, Student student) {
		
			log.info("Inside the StudentServiceImpl in updateStudent()");
			Optional<Student> existingStudent = studentRepo.findById(id);
			log.info("Inside the StudentServiceImpl in if block check the condition");
			if (existingStudent.isPresent()) {
				Student oldData = existingStudent.get();
				
				if(!ObjectUtils.isEmpty(student.getFullName())) {
					oldData.setFullName(student.getFullName());
				}
				
				if(!ObjectUtils.isEmpty(student.getAddress())) 
				{
					oldData.setAddress(student.getAddress());
				}
				
				if(!ObjectUtils.isEmpty(student.getEmail()))
				{
					oldData.setEmail(student.getEmail());
				}
				
				if(!ObjectUtils.isEmpty(student.getMobileNumber()))
				{
					oldData.setMobileNumber(student.getMobileNumber());
				}
				if(!ObjectUtils.isEmpty(student.getEnrollment().getEnrollment_No()))
				{
					oldData.getEnrollment().setEnrollment_No((student.getEnrollment().getEnrollment_No()));
				}
				/*
				 * oldData.setAddress(student.getAddress());
				 * oldData.setFullName(student.getFullName());
				 * oldData.setEmail(student.getEmail());
				 * oldData.setMobileNumber(student.getMobileNumber());
				 */
				 Student existStudent1 = studentRepo.save(oldData);

				log.info("Inside the if Block Condition is true return message Student updated Successfully");
				return "Student updated successfully";
		

			} else

			{	
			
				throw new CustomException(608,"given Student  id is null,please send some id to be searched" , LocalDate.now());
				//log.info("Inside the else Block condition is false return message Student id is not found");
			//	return "Student id is not updated =" + id;

			}
			
	        
		//	Enrollment enroll = new Enrollment();
			//enroll.setEnrollment_No(student.get);

			
	}

	@Override
	public String deleteStudent(Integer id) {

		log.info("Inside the StudentServiceImpl in deleteStudentBYid()");
		Optional<Student> data = studentRepo.findById(id);
		if (data.isPresent()) {

			studentRepo.deleteById(id);
			log.info("Inside the return message Student deleted Successfully");
			return "Student deleted Successfully";
		} else {
			throw new CustomException(609,
					"given Student  id :- " + id + "is not found,please send some id to be searched", LocalDate.now());
		}

	}
}
