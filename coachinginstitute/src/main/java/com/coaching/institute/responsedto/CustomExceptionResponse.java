package com.coaching.institute.responsedto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionResponse {
  
	private Integer statusCode;
	
	private String message;
	
	private LocalDate date;
	
}
