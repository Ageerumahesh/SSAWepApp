package com.ssa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;


@Entity
@Data
@Table(name = "Enrollment")

public class EnrollmentEntity {

	@Id
	@GenericGenerator(strategy="com.ssa.generator.SSNCustomGenraror",name = "SSN_SEQUENCE")
	@GeneratedValue(generator = "SSN_SEQUENCE")
	@Column(name = "tciEnrollId")
	private Long enrollId;
	
	@Column(name = "tcsfrstNm")
	private String frstNm;
	
	@Column(name = "tcslstNm")
	private String lstNm;
	
	@Column(name = "tcsgndr")
	private String gndr;
	
	@Column(name = "tcdDate")
	private LocalDate date;
	
	@Column(name = "tcsStateNm")
	private String stateNm;
	
	
	
	
}
