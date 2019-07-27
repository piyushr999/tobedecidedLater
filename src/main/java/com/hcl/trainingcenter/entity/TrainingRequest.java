package com.hcl.trainingcenter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class TrainingRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long registrationId;
	
	private String course;
	
	private String proficiency;
	
	private String courseDate;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "trainee_id")
	private User traineeId;
	
	@ManyToOne
	@JoinColumn(name = "trainer_id")
	private User trainerId;
	
}
