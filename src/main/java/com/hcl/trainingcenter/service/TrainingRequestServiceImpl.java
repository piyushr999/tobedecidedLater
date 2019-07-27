package com.hcl.trainingcenter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.trainingcenter.dto.ResponseData;
import com.hcl.trainingcenter.dto.TrainingRequestDto;
import com.hcl.trainingcenter.entity.User;
import com.hcl.trainingcenter.repository.TrainingRequestRepository;
import com.hcl.trainingcenter.repository.UserRepository;

public class TrainingRequestServiceImpl implements TrainingRequestService {

	@Autowired
	private TrainingRequestRepository trainingRequestRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseData courseRequest(TrainingRequestDto trainingRequestDto) {

		Optional<User> traineeUserOptional = userRepository.findById(trainingRequestDto.getTraineeUserId());
		if(traineeUserOptional.isPresent()) {
		   User traineeUser = traineeUserOptional.get();
		}

		
		
		return null;
	}

}
