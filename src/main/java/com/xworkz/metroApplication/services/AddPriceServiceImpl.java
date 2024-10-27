package com.xworkz.metroApplication.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.metroApplication.dto.AddPriceDTO;
import com.xworkz.metroApplication.entity.AddPriceEntity;
import com.xworkz.metroApplication.repository.AddPriceRepo;

@Service
public class AddPriceServiceImpl implements AddPriceService {
	
	@Autowired
	private AddPriceRepo addPriceRepo;

	@Override
	public boolean onAddPriceInService(AddPriceDTO addPriceDTO) {
		if(addPriceDTO.getSource().isEmpty() && addPriceDTO.getDestination().isEmpty()
		 && addPriceDTO.getTrainType().isEmpty()) {
		return false;	
		}
		AddPriceEntity addPriceEntity=new AddPriceEntity();
		BeanUtils.copyProperties(addPriceDTO, addPriceEntity);
		return addPriceRepo.onAddPrice(addPriceEntity);
	}

}
