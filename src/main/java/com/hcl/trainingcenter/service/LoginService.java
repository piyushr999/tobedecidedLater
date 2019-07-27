package com.hcl.trainingcenter.service;

import org.springframework.stereotype.Service;

import com.hcl.trainingcenter.dto.ResponseData;
import com.hcl.trainingcenter.dto.UserDto;

@Service
public interface LoginService {

	ResponseData loginUser(UserDto userDto);

}
