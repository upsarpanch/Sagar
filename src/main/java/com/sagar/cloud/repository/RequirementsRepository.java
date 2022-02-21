package com.sagar.cloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sagar.cloud.model.Requirements;

public interface RequirementsRepository extends JpaRepository<Requirements, Integer>{

	@Query(value="select * from requirements where item=? and status=0",nativeQuery=true)
	Requirements findByItem(String item);

	List<Requirements> findByCustomerId(String userId);

	@Query(value="select * from requirements where requirement_id=? and customer_id=?",nativeQuery=true)
	Requirements findByCustomerIdAndRequirements(Integer requirementId, String customerId);

	@Query(value="select * from requirements where item=? and customer_id=?",nativeQuery=true)
	Requirements findByItemRecords(String item, String userId);

	/*
	 * @Query(
	 * value="SELECT DISTINCT CUSTOMER_ID,status,requirementId FROM Requirements where status='pending'"
	 * ,nativeQuery=true) List<Requirements> findDistinctCustomerId();
	 */

	/*
	 * @Query(value="SELECT * FROM Requirements o JOIN o.user u WHERE u.userId=?"
	 * ,nativeQuery=true) List<Requirements> findUserRequirements(Integer userId);
	 */
	

	/*
	 * @Query(value="select * from requirements where User.userId=? and status=0"
	 * ,nativeQuery=true) List<User> findAllUserReq(Integer userId);
	 */
}
