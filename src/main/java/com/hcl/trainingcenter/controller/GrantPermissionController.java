package com.hcl.trainingcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trainingcenter.dto.TrainingRequestDto;
import com.hcl.trainingcenter.service.GrantPermissionServiceImpl;

@RestController
@RequestMapping("/")
public class GrantPermissionController {
	
	@Autowired
	GrantPermissionServiceImpl grantPermissionServiceImpl;
	
	@PostMapping("/trainer/approval")
	public ResponseEntity<Object> approveStatus(@RequestBody TrainingRequestDto trainingRequestDto)
	{
		
		return new ResponseEntity<>(grantPermissionServiceImpl.findByUserId(trainingRequestDto), HttpStatus.OK);
	}

}
