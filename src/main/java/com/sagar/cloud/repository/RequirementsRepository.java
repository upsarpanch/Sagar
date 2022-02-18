package com.sagar.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sagar.cloud.model.Requirements;

public interface RequirementsRepository extends JpaRepository<Requirements, Integer>{

	@Query(value="select * from requirements where item=? and status=0",nativeQuery=true)
	Requirements findByItem(String item);

	/*
	 * @Query(value="SELECT * FROM Requirements o JOIN o.user u WHERE u.userId=?"
	 * ,nativeQuery=true) List<Requirements> findUserRequirements(Integer userId);
	 */
	

	/*
	 * @Query(value="select * from requirements where User.userId=? and status=0"
	 * ,nativeQuery=true) List<User> findAllUserReq(Integer userId);
	 */
}
