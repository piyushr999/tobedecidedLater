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
	public TrainingRequestRepository trainingRequestRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	
	
	public ResponseData findByUserId(GrantPermissionDto grantPermissionDto)
	{
	   ResponseData response =new ResponseData();
	   Optional<TrainingRequest> trainingRequest = trainingRequestRepository.findById(grantPermissionDto.getRegistrationId());
	   
	   if(trainingRequest.isPresent()) {
		   TrainingRequest tainReq = trainingRequest.get();
		   tainReq.setStatus(grantPermissionDto.getStatus());
		   tainReq.setCourseDate(grantPermissionDto.getCourseDate());
		   trainingRequestRepository.save(tainReq);
		   
	   }
	   response.setData(trainingRequest);
	   response.setHttpStatus(HttpStatus.OK);
	   response.setMessage("Your Request has been successfully "+grantPermissionDto.getStatus());
	   
	   return response;
	}
	

}
