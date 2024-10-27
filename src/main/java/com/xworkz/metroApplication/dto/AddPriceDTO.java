package com.xworkz.metroApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPriceDTO {
	
	private Integer id;
	private String source;
	private String destination;
	private String trainType;
	private Double price;

}
