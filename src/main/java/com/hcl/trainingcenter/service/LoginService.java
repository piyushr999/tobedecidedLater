package com.hcl.trainingcenter.service;

import com.hcl.trainingcenter.dto.ResponseData;
import com.hcl.trainingcenter.dto.UserDto;

public interface LoginService {

	ResponseData loginUser(UserDto userDto);

}
