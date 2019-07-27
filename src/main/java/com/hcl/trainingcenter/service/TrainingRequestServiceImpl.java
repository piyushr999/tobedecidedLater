package com.hcl.trainingcenter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.trainingcenter.dto.ResponseData;
import com.hcl.trainingcenter.dto.TrainingRequestDto;
import com.hcl.trainingcenter.entity.TrainingRequest;
import com.hcl.trainingcenter.entity.User;
import com.hcl.trainingcenter.repository.TrainingRequestRepository;
import com.hcl.trainingcenter.repository.UserRepository;

@Service
public class TrainingRequestServiceImpl implements TrainingRequestService {

	@Autowired
	private TrainingRequestRepository trainingRequestRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseData courseRequest(TrainingRequestDto trainingRequestDto) {

		ResponseData response = new ResponseData();
		Optional<User> traineeUserOptional = userRepository.findById(trainingRequestDto.getTraineeUserId());
		if (traineeUserOptional.isPresent()) {
			User traineeUser = traineeUserOptional.get();
			User trainerUser = userRepository.findByTechnologyAndUserType(trainingRequestDto.getCourse(), "Trainer");
			if (ObjectUtils.isEmpty(trainerUser)) {

				response.setMessage("Trainer is not availabe for this course");
				response.setHttpStatus(HttpStatus.NOT_FOUND);
				List<Object[]> trainerAvailable = userRepository.getAllTrainers();
				response.setData(trainerAvailable);

				return response;
			}
			TrainingRequest trainingRequest = new TrainingRequest();
			trainingRequest.setCourse(trainingRequestDto.getCourse());
			trainingRequest.setProficiency(trainingRequestDto.getProficiency());
			trainingRequest.setStatus("Pending");
			trainingRequest.setTraineeId(traineeUser);
			trainingRequest.setTrainerId(trainerUser);
			trainingRequestRepository.save(trainingRequest);
			
			response.setMessage("Your request has been send to trainer for acceptance");
			response.setHttpStatus(HttpStatus.OK);
			return response;
		}

		response.setMessage("Incorrect traineeId");
		response.setHttpStatus(HttpStatus.BAD_REQUEST);
		return response;
	}

}
