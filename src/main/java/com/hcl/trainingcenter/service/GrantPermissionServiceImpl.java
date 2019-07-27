package com.hcl.trainingcenter.service;

import java.util.Optional;

import org.apache.http.protocol.ResponseDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.trainingcenter.dto.GrantPermissionDto;
import com.hcl.trainingcenter.dto.ResponseData;
import com.hcl.trainingcenter.dto.TrainingRequestDto;
import com.hcl.trainingcenter.entity.TrainingRequest;
import com.hcl.trainingcenter.repository.TrainingRequestRepository;
import com.hcl.trainingcenter.repository.UserRepository;

@Service
public class GrantPermissionServiceImpl {
	
	@Autowired
	TrainingRequestRepository trainingRequestRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	
	public ResponseData findByUserId(GrantPermissionDto grantPermissionDto)
	{
	   ResponseData response =new ResponseData();
	   Optional<TrainingRequest> trainingRequest = trainingRequestRepository.findById(grantPermissionDto.getRegistrationId());
	   
	   if(trainingRequest.isPresent()) {
		   trainingRequest.get().setStatus(grantPermissionDto.getStatus());
		   
	   }
	   response.setData(trainingRequest);
	   response.setHttpStatus(HttpStatus.OK);
	   response.setMessage("Your Request has been successfully "+grantPermissionDto.getStatus());
	   
	   return response;
	}
	

}
