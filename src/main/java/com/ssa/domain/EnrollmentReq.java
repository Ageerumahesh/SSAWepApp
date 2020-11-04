package com.ssa.domain;

import java.time.LocalDate;



import lombok.Data;

@Data
public class EnrollmentReq {

	private String frstNm;

	private String lstNm;

	private String gndr;

	private LocalDate date;
	
	private String stateNm;
}
