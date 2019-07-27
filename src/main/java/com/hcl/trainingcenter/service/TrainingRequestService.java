package com.hcl.trainingcenter.service;


import com.hcl.trainingcenter.dto.ResponseData;
import com.hcl.trainingcenter.dto.TrainingRequestDto;

public interface TrainingRequestService {

	public ResponseData courseRequest(TrainingRequestDto trainingRequestDto);
}
