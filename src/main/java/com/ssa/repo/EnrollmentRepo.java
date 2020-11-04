package com.ssa.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssa.entity.EnrollmentEntity;

public interface EnrollmentRepo extends JpaRepository<EnrollmentEntity, Serializable> {

	public EnrollmentEntity findByEnrollId(Long enrolId);
}
