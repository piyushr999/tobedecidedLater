package com.hcl.trainingcenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.trainingcenter.dto.ResponseData;
import com.hcl.trainingcenter.dto.UserDto;
import com.hcl.trainingcenter.entity.TrainingRequest;
import com.hcl.trainingcenter.entity.User;
import com.hcl.trainingcenter.repository.TrainingRequestRepository;
import com.hcl.trainingcenter.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TrainingRequestRepository trainingRequestRepository;

	@SuppressWarnings("unused")
	@Override
	public ResponseData loginUser(UserDto userDto) {
		ResponseData responseData = new ResponseData();
		User user = userRepository.findByUserNameAndPassword(userDto.getUserName(), userDto.getPassword());
		if (user == null) {
			responseData.setHttpStatus(HttpStatus.BAD_REQUEST);
			responseData.setMessage("Please check user name and password..! and try again");
			return responseData;
		} else if (user.getUserType().equalsIgnoreCase("trainee")) {
			List<TrainingRequest> trainingList = trainingRequestRepository.findByTraineeId(user);
			responseData.setData(trainingList);
			responseData.setMessage("Trainee Login Succesfully..");
		} else if (user.getUserType().equalsIgnoreCase("trainer")) {
			List<TrainingRequest> trainingList = trainingRequestRepository.findByTrainerIdAndStatus(user, "Pending");
			if (trainingList.isEmpty()) {
				responseData.setData("There is no trainee request raise");
				responseData.setMessage("Trainer Login Succesfully..");
			} else {
				responseData.setData(trainingList);
				responseData.setMessage("Trainer Login Succesfully..");
			}
		}
		responseData.setHttpStatus(HttpStatus.OK);
		return responseData;
	}

}
