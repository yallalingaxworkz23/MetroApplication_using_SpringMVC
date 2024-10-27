package com.xworkz.metroApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.metroApplication.dto.AddTrainDTO;
import com.xworkz.metroApplication.services.AddTrainService;

@Controller
@RequestMapping("/")
public class AddTrainController {
	
	@Autowired
	private AddTrainService  addTrainService;
	
	
	public AddTrainController() {
           System.out.println("invoking in the AddTrianController..");
	}
	
	@PostMapping("/addTrain")
	public String onAddTrain(AddTrainDTO addTrainDTO,Model mode) {
		if(addTrainService.onAddTrainInSerive(addTrainDTO)) {
			
			return "profile";
		}
		mode.addAttribute("trainadd", "train not added..");  
		return "prfile";
	}

}
