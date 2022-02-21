package com.sagar.cloud.model;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer salesId;

	private Double totalSales;

	private String createdDate;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<User> user;

}
