package com.hcl.trainingcenter.dto;

import com.hcl.trainingcenter.entity.User;

import lombok.Data;

@Data
public class GrantPermissionDto {


	private Long registrationId;
	
	private String status;
	
	private String courseDate;
	
	private Long traineeId;
	
	
}
