package com.coaching.institute.model;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
//import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String fullName;
	
	private String address;
	
	private Long mobileNumber;
     
	@JsonManagedReference
	@OneToMany(mappedBy="faculty")
	private List<Student> student;
	
	
	@Override
    public String toString() {
        String email = null;
		return "StudentEntity [id=" + id + ", fullName=" + fullName + ", address=" + address + ", email="
                + email + ", mobileNumber=" + mobileNumber + "]";
    }

}
