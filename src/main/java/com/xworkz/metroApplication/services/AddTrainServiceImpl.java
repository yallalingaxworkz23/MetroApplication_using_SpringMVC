package com.xworkz.metroApplication.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.metroApplication.dto.AddTrainDTO;
import com.xworkz.metroApplication.entity.AddTrainEntity;
import com.xworkz.metroApplication.repository.AddTrianRepo;

@Service
public class AddTrainServiceImpl implements AddTrainService {
	
	@Autowired
	private AddTrianRepo addTrianRepo;

	@Override
	public boolean onAddTrainInSerive(AddTrainDTO addTrainDTO) {
		AddTrainEntity addTrainEntity=new AddTrainEntity();
		BeanUtils.copyProperties(addTrainDTO, addTrainEntity);
		return addTrianRepo.onAddTrianInRepo(addTrainEntity);
	}

}
