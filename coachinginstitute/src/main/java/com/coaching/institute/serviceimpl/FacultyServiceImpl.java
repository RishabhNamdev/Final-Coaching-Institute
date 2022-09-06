package com.coaching.institute.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coaching.institute.model.Faculty;
import com.coaching.institute.model.Student;
import com.coaching.institute.repository.FacultyRepository;
import com.coaching.institute.repository.StudentRepository;
import com.coaching.institute.service.FacultyService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FacultyServiceImpl implements FacultyService{

	@Autowired
	private FacultyRepository facultyRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public Faculty saveFaculty(Faculty faculty) {
		log.info("Inside the FacultyServiceImpl in saveFaculty");
		return facultyRepo.save(faculty);
	}

	@Override
	public Optional<Faculty> getFacultyByid(Integer id) {
	log.info("Inside the FacultyServiceImpl in getFacultyByid");	
	Optional<Faculty> fac = facultyRepo.findById(id);
	log.info("Inside the  FacultyServiceImpl in if block check the condition");
	if(fac.isPresent()) 
	{
		Faculty fac1 = new Faculty();
		fac1.getId();	
	}
		
		return fac;
	}

	@Override
	public List<Faculty> getAllFaculty() {
		log.info("Inside the  FacultyServiceImpl in getAllFaculty");
		List<Faculty> listoffaculty = facultyRepo.findAll();
		return listoffaculty;
		
	}

	@Override
	public String updateFaculty(Integer id, Faculty faculty) {
		log.info("Inside the FacultyServiceImpl in update Faculty");
		Optional<Faculty> existingFaculty = facultyRepo.findById(id);
		log.info("Inside the FacultyServiceImpl in if block check the condition");
		if(existingFaculty.isPresent()) 
		{
			Faculty oldFaculty = existingFaculty.get();
			oldFaculty.setFullName(faculty.getFullName());
			oldFaculty.setAddress(faculty.getAddress());
			oldFaculty.setMobileNumber(faculty.getMobileNumber());
			facultyRepo.save(oldFaculty);
			log.info("Inside the if block condition is trur return Faculty updated Successfully ");
			return("Faculty updated Successfully");
		}
		else
		{
			log.info("Inside the else block condition is false return Faculty id is not found");
			return ("Faculty id is not found"+id);
		}
		
	}

	@Override
	public String deleteFaculty(Integer id)
	{
		log.info("Inside the FacultyServiceImpl in deleteFaculty()");
		facultyRepo.deleteById(id);
		log.info("Inside the FacultyServiceImpl in return Faculty deleted Successfully");
	   return "Faculty deleted Successfully";
	}
	
	@Override
	public List<Student>  getAllStudentByid(Integer id) {
		log.info("Inside the FacultyServiceImpl in getAllStudentByid");
		List<Student> stu1 = studentRepo.findAllByfacultyId(id);
		System.out.println(stu1);
		log.info("Inside the FacultyServiceImpl return list of student");
	      return stu1;
		
	}

}
