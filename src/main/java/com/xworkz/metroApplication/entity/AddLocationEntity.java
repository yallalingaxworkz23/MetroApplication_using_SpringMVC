package com.xworkz.metroApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="addLocation")
public class AddLocationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="al_id")
	private Integer id;
	
	@Column(name="al_trainType")
	private String trainType;
	
	@Column(name="al_addlocation")
	private String addLocation;

	
}
