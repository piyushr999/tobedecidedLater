package com.hcl.trainingcenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.trainingcenter.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByTechnologyAndUserType(String technology, String userType);
	
	@Query(value = "SELECT technology from User WHERE user_type = 'Trainer'", nativeQuery = true)
	public List<Object[]> getAllTrainers();

	public User findByUserNameAndPassword(String userName, String password);
}
