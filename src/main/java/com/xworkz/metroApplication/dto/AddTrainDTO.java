package com.xworkz.metroApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTrainDTO {
	
	private Integer id;
	private String trainType;
	private String trainNum;

}
