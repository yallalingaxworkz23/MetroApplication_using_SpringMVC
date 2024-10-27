package com.xworkz.metroApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.metroApplication.dto.AddPriceDTO;
import com.xworkz.metroApplication.services.AddPriceService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class AddPriceController {
	
	@Autowired
	private AddPriceService addPriceService;
	
	public AddPriceController() {
	log.info("invoking in the AddPriceController ...");
	}
	
	@PostMapping("/addPrice")
	public String onAddPrice(AddPriceDTO addPriceDTO,Model model) {
		if(addPriceService.onAddPriceInService(addPriceDTO)) {
			return "profile";
		}
		model.addAttribute("foraddprice","price is not saved");
		return "profile";
	}

}
