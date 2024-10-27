package com.xworkz.metroApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="addPrice")
public class AddPriceEntity {

	@Id
	@Column(name="ap_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="ap_source")
	private String source;
	@Column(name="ap_destination")
	private String destination;
	@Column(name="ap_trainType")
	private String trainType;
	@Column(name="ap_price")
	private Double price;
}
