package com.ssa.error;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.ssa.props.AppProperties;

@RestController
@ControllerAdvice
public class RestControlerHandler {

	@Autowired
	private AppProperties props;

	@ExceptionHandler(value = EnrollmentNotFoundException.class)
	public ResponseEntity<ApiError> handleEnrollmentNotFoundException() {

		ApiError err = null;
		err = new ApiError(400, new Date(), props.getMessages().get("ENROLL_NOT_FOUND"));
		return new ResponseEntity<ApiError>(err, HttpStatus.BAD_REQUEST);
	}

}
