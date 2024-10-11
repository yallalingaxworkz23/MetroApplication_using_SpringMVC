package com.xworkz.metroApplication.services;

import com.xworkz.metroApplication.dto.UserDTO;

public interface UserRegisterService {
	
	 boolean onRigesterSave(UserDTO userDTO);
	 
	 UserDTO onFindByEmailid(String emailid);
	 
	 boolean onUpdateProfile(UserDTO userDTO);

}
