package com.hcl.trainingcenter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trainingcenter.dto.TrainingRequestDto;

@RestController
@RequestMapping("/trainee")
public class TrainingRequestController {

	public ResponseEntity<Object> courseRequest(TrainingRequestDto trainingRequestDto){
		
		return new ResponseEntity<>("",HttpStatus.OK);
	}
}
