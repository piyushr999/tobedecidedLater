package com.hcl.trainingcenter.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hcl.trainingcenter.entity.TrainingRequest;

@Repository
public interface TrainingRequestRepository extends JpaRepository<TrainingRequest, Long> {
	
	
}
