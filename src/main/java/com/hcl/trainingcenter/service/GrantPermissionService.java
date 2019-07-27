package com.hcl.trainingcenter.service;

import org.springframework.stereotype.Service;

import com.hcl.trainingcenter.dto.GrantPermissionDto;
import com.hcl.trainingcenter.dto.ResponseData;
import com.hcl.trainingcenter.entity.User;


public interface GrantPermissionService {

	
	public ResponseData findByUserId(GrantPermissionDto grantPermissionDto);
}
