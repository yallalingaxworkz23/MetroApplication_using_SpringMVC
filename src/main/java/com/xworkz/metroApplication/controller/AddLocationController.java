package com.xworkz.metroApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.metroApplication.dto.AddLocationDTO;
import com.xworkz.metroApplication.services.AddLocationService;

@Controller
@RequestMapping("/")
public class AddLocationController {
	
	@Autowired
	private AddLocationService addLocationService;
	
	public AddLocationController() {
	System.out.println("invoking in the AddLocation Controller...");
	}
	
	@PostMapping("/addLocation")
	public String onSaveAddedLocation(AddLocationDTO addLocationDTO,Model model) {
		System.out.println("dto are.."+addLocationDTO);
		if(addLocationService.onAddLocationinService(addLocationDTO)) {
			return "profile";
		}
		
		model.addAttribute("forlocation", "data is not added");
		return "profile";
	}
	

}
