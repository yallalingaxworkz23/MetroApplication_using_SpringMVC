package com.xworkz.metroApplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xworkz.metroApplication.dto.UserDTO;
import com.xworkz.metroApplication.services.UserLoginService;
import com.xworkz.metroApplication.services.UserRegisterService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class UserController {
	
	@Autowired
	private UserLoginService userLoginService;
	
	@Autowired
	UserRegisterService userRegisterService;
	
	public UserController() {
	log.info("running in the user Controller...");
	}
	
	@PostMapping("/userRigester")
	public String onregister(@Valid UserDTO userDTO ,BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes) {
		log.info("invoking in the onregister... method..");
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> errors= bindingResult.getAllErrors();
			errors.forEach(y->log.info("for spring validation errors.."+y.getObjectName()+"message is.."+y.getDefaultMessage()));
			return "register";
		}else {
			boolean toknow=userRegisterService.onRigesterSave(userDTO);
			redirectAttributes.addFlashAttribute(userDTO);
			if(toknow==true) {
				return "redirect:/Index";	
			}
			return "register";
		}
		
	}
	
	@GetMapping("/Index")
	public String redirectuserregister() {
		return "Index";
	}
	
	@GetMapping("/editprofile")
	public String onEditProfile(String emailid,Model model) {
		UserDTO userDTO= userRegisterService.onFindByEmailid(emailid);
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("username", emailid);
		return "userEdit";
	}
	
	@PostMapping("/userupdate")
	public String onUpdateProfile(@Valid UserDTO userDTO,BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
		 List<ObjectError> errors=bindingResult.getAllErrors();
		 errors.forEach(y->log.info("invalid inputs are.. "+y.getObjectName()+"and message is .."+y.getDefaultMessage()));
		 model.addAttribute("userDTO", userDTO);
		 return "userEdit";
		}
		
		if(userRegisterService.onUpdateProfile(userDTO)) {
			userLoginService.sendmail(userDTO.getEmailid(), "profile update", "You are profile is updated.. thankyou");
			return "Index";
		}
		model.addAttribute("userDTO", userDTO);
		return "userEdit";
	}

}

