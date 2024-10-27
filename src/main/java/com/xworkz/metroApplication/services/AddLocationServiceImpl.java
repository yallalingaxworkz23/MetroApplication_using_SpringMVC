package com.xworkz.metroApplication.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.metroApplication.dto.AddLocationDTO;
import com.xworkz.metroApplication.entity.AddLocationEntity;
import com.xworkz.metroApplication.repository.AddLocationRepo;

@Service
public class AddLocationServiceImpl implements AddLocationService{
	
	@Autowired
	private AddLocationRepo addlocationrepo;

	@Override
	public boolean onAddLocationinService(AddLocationDTO addLocationDTO) {
		if(addLocationDTO.getAddLocation()!=null) {
			AddLocationEntity addLocationEntity=new AddLocationEntity();
			BeanUtils.copyProperties(addLocationDTO, addLocationEntity);
			return addlocationrepo.onAddLocation(addLocationEntity);	
		}
		return false;
	}

}
