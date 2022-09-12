package com.coaching.institute.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coaching.institute.model.Enrollment;
import com.coaching.institute.repository.EnrollmentRepository;
import com.coaching.institute.service.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	@Autowired
	private EnrollmentRepository enrollmentRepo;

	@Override
	public Enrollment saveEnrollmen_No(Enrollment enrollment) {

		return enrollmentRepo.save(enrollment);
	}
	
	
	@Override
	public Optional<Enrollment> getEnrollmentNoByid(Integer id) {
		Optional<Enrollment> enroll = enrollmentRepo.findById(id);
		if(enroll.isPresent()) 
		{
			Enrollment enrollment1 = new Enrollment();
			enrollment1.getId();
     	}
		return enroll;
		
	}

//	@Override
//	public Optional<Enrollment> getEnrollmentNoByStudentid(Integer id) {
//	 Optional<Enrollment> optenroll = enrollmentRepo.findByStudentid(id);
//		if(optenroll.isPresent()) 
//		{
//			Enrollment enrollment1 = new Enrollment();
//			enrollment1.getStudent();
//		}
//		return optenroll;
//	}

	public List<Enrollment> getAllEnrollment()
	{
		List<Enrollment> listofenroll =  enrollmentRepo.findAll();
		return listofenroll;
	}
}
