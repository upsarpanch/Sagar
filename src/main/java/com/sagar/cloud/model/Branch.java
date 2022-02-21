package com.sagar.cloud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer branchId;

	private String branchName;

	private String branchOwnerName;

	private String branchAddress;

	private String createdDate;

}
