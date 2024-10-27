package com.xworkz.metroApplication.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.xworkz.metroApplication.dto.UserDTO;
import com.xworkz.metroApplication.services.UserLoginService;
import com.xworkz.metroApplication.services.UserRegisterService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class UserController {
	
	private static String UPLOADED_FOLDER = "E://metro-application-user-images//";
	
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

    @PostMapping("/uploadUserImage") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file, String emailid,Model model,
                             HttpServletRequest httpServletRequest,RedirectAttributes redirectAttributes) {
    	

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            model.addAttribute("username", emailid);
            return "profile";
        }
        UserDTO userDTO= userRegisterService.onFindByEmailid(emailid);

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            
            userDTO.setFilename(path.getFileName().toString());
            userDTO.setFileContentType(file.getContentType());
            if(userRegisterService.onUpdateProfile(userDTO)) {
            	model.addAttribute("filename", userDTO.getFilename());
            	HttpSession httpSession= httpServletRequest.getSession(true);
            	httpSession.setAttribute("picPath", userDTO.getFilename());
//            	model.addAttribute("username", userDTO.getEmailid());
            	
            	log.info("invoking in the file uploded.. method is updated are not.. "+userDTO.getEmailid());
            	return "profile";
            }

            redirectAttributes.addFlashAttribute("message", 
                        "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "profile";
    }

  

	@GetMapping("/display")
	public void onDownload(@RequestParam @PathVariable String filename, UserDTO userDTO,HttpServletResponse response)
			throws IOException {
        System.err.println("================================================"+filename);
		response.setContentType("image/jpeg");
		File file = new File("E://metro-application-user-images//" +filename);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		ServletOutputStream out = response.getOutputStream();
		IOUtils.copy(in, out);
		response.flushBuffer();
	}
}

