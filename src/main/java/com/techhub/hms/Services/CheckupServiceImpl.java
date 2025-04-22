package com.techhub.hms.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.hms.Models.Checkup;
import com.techhub.hms.Repository.CheckupRepo;

@Service
public class CheckupServiceImpl implements CheckupService {

	@Autowired
	CheckupRepo CheckRepo;

	@Override
	public boolean isAddPrecription(Checkup checkup) {
		
		return CheckRepo.isAddPrecription(checkup);
	}
}
