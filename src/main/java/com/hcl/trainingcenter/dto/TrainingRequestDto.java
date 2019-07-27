package com.hcl.trainingcenter.dto;

import lombok.Data;

@Data
public class TrainingRequestDto {

	private Long traineeUserId;

	private String course;

	private String proficiency;
}
