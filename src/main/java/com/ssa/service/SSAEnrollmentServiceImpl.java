package com.ssa.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.domain.EnrollmentReq;
import com.ssa.domain.EnrollmentRes;
import com.ssa.entity.EnrollmentEntity;
import com.ssa.props.AppProperties;
import com.ssa.repo.EnrollmentRepo;
import com.ssa.res.AppConstants;

@Service
public class SSAEnrollmentServiceImpl implements SSAEnrollmentService {

	@Autowired
	private EnrollmentRepo enrlmntRepo;

	@Autowired
	private AppProperties props;

	@Override
	public Long saveSSAEnrollment(EnrollmentReq enrlmnt) {
		EnrollmentEntity enrlmntEntity = null, savedEnrlmntEntity = null;

		enrlmntEntity = new EnrollmentEntity();
		BeanUtils.copyProperties(enrlmnt, enrlmntEntity);
		savedEnrlmntEntity = enrlmntRepo.save(enrlmntEntity);
		return savedEnrlmntEntity != null ? savedEnrlmntEntity.getEnrollId() : 0L;
	}

	@Override
	public HashMap<EnrollmentRes, String> enrollverfication(String ssn) {
		Long ssnValue = 0L;
		EnrollmentRes enrlmntRes = null;
		HashMap<EnrollmentRes, String> hmap = new HashMap<EnrollmentRes, String>();
		ssnValue = Long.parseLong(ssn.replaceAll("-", ""));
		EnrollmentEntity resEntity = enrlmntRepo.findByEnrollId(ssnValue);
		enrlmntRes = new EnrollmentRes();

		if (resEntity != null) {
			BeanUtils.copyProperties(resEntity, enrlmntRes);
			hmap.put(enrlmntRes, AppConstants.FOUND);
			return hmap;
		}

		hmap.put(enrlmntRes, AppConstants.NOT_FOUND);
		return hmap;

	}

}
