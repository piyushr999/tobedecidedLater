package com.hcl.trainingcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trainingcenter.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	

	public User findByTechnologyAndUserType(String technology, String userType);
}
