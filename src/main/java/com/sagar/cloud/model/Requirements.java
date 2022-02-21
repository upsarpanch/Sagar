package com.sagar.cloud.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Requirements {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer requirementId;

	private String createdDate;

	private Date endDate;

	private String paymentMode;
	
	private String customerId;

	private String item;
	private String quantity;
	private double netAmount;
	private String unit;
	private String status;

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH}, fetch = FetchType.EAGER)
	List<User> user;

}
