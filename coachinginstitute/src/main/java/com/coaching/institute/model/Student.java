package com.coaching.institute.model;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String fullName;
	
	private String address;
	
	private String email;
	
	private Long mobileNumber;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name ="faculty_id")
	private Faculty faculty; 
	

    @OneToOne
    @JoinColumn(name = "Enrollment_id")
    private Enrollment enrollment;
	

	
	
	//String rep = "Hex: " + this.toString();
	
	
//	@Override
//    public String toString() {
//        return "StudentEntity [id=" + id + ", fullName=" + fullName + ", address=" + address + ", email="
//                + email + ", mobileNumber=" + mobileNumber + "]";
//    }
	
	@Override
  public String toString() {
      return "FacultyEntity [id=" + id + ", fullName=" + fullName + ", address=" + address + ", mobileNumber="
              + mobileNumber + "]";
  }
	

	
	
	

}
