package com.hcl.trainingcenter.dto;

import lombok.Data;

@Data
public class TrainingRequestDto {

	private Long userId;

	private String course;

	private String proficiency;
}
