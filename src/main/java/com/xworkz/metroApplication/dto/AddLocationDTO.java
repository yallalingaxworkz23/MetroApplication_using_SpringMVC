package com.xworkz.metroApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddLocationDTO {

	private Integer id;
	private String trainType;
	private String addLocation;
}
