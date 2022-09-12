package com.coaching.institute.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coaching.institute.model.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>{

	//Enrollment save(Enrollment enrollment);
	//Optional<Enrollment>findByStudentid(Integer id);

}
