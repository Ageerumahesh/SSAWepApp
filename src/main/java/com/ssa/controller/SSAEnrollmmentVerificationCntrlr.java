package com.ssa.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssa.domain.EnrollmentRes;
import com.ssa.error.EnrollmentNotFoundException;
import com.ssa.props.AppProperties;
import com.ssa.res.AppConstants;
import com.ssa.service.SSAEnrollmentService;

@RestController
public class SSAEnrollmmentVerificationCntrlr {

	@Autowired
	private SSAEnrollmentService enrlSrvc;
	@Autowired
	private AppProperties props;

	@PostMapping(AppConstants.VERIFICATION_ENROLL)
	public ResponseEntity<EnrollmentRes> handleSbmtBtn(@RequestParam String ssn) {
		Set set = null;
		Iterator itrtr = null;
		Map.Entry mapEntry = null;
		HashMap<EnrollmentRes, String> hmap = enrlSrvc.enrollverfication(ssn);
		set = hmap.entrySet();
		itrtr = set.iterator();
		if (itrtr.hasNext()) {
			mapEntry = (Map.Entry) itrtr.next();
		}
		if (mapEntry.getValue().equals("notfound")) {
			throw new EnrollmentNotFoundException(props.getMessages().get("ENROLL_NOT_FOUND"));
		}

		return new ResponseEntity<EnrollmentRes>((EnrollmentRes) mapEntry.getKey(), HttpStatus.CREATED);

	}
}
