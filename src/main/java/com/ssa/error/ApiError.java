package com.ssa.error;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
	
	
	private Integer errorCode;
	private Date date;
	private String errMsg;
	
	

}
