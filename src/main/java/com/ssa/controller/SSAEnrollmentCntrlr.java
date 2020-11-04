package com.ssa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssa.domain.EnrollmentReq;
import com.ssa.props.AppProperties;
import com.ssa.res.AppConstants;
import com.ssa.service.SSAEnrollmentService;

@RestController
@RequestMapping(value = AppConstants.INDEX_URI)
public class SSAEnrollmentCntrlr {

	@Autowired
	private SSAEnrollmentService enrlSrvc;

	@Autowired
	private AppProperties props;

	@CrossOrigin(origins = "*")
	@PostMapping(AppConstants.CREATE_ENRLMNT)
	public ResponseEntity<String> handleSbmtBtn(@RequestBody EnrollmentReq enrlmntReq) {
		Long ssn = 0L;
		System.out.println(enrlmntReq);
		String frmtResSSN = null;
		ssn = enrlSrvc.saveSSAEnrollment(enrlmntReq);
		frmtResSSN = frmtSSN(ssn);
		if(ssn==0L) {
			new ResponseEntity<String>(props.getMessages().get("ENROLL_FAIL_MSG"),
					HttpStatus.BAD_REQUEST); 
		}
		return new ResponseEntity<String>(props.getMessages().get("ENROLL_SAVE_MSG") + " : " + frmtResSSN,
				HttpStatus.CREATED);
	}

	public String frmtSSN(Long ssn) {
		StringBuilder builder = null, append = null;
		String ssnVal = String.valueOf(ssn);
		// format
		builder = new StringBuilder();
		append = builder.append(ssnVal.substring(0, 3)).append("-").append(ssnVal.substring(3, 5)).append("-")
				.append(ssnVal.substring(5, 9));
		return append.toString();
	}
}
