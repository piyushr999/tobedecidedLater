package com.hcl.trainingcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trainingcenter.dto.ResponseData;
import com.hcl.trainingcenter.dto.TrainingRequestDto;
import com.hcl.trainingcenter.service.TrainingRequestService;

@RestController
@RequestMapping("/trainee")
public class TrainingRequestController {

	@Autowired
	private TrainingRequestService trainingRequestServiceImpl;

	public ResponseEntity<Object> courseRequest(TrainingRequestDto trainingRequestDto) {
		ResponseData response = trainingRequestServiceImpl.courseRequest(trainingRequestDto);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}
}
