package com.ssa.service;

import java.util.HashMap;
import java.util.Map;

import com.ssa.domain.EnrollmentReq;
import com.ssa.domain.EnrollmentRes;

public interface SSAEnrollmentService {
	
	public Long saveSSAEnrollment(EnrollmentReq enrlmnt);
	
	public HashMap<EnrollmentRes, String> enrollverfication(String ssn);
	

}
