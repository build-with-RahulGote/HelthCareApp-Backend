package com.techhub.hms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.hms.Models.Patients;
import com.techhub.hms.Repository.patientsRepository;
@Service
public class patientsServiceImpl  implements patientsService{
  @Autowired
  patientsRepository patientsRepo;
	@Override
	public boolean isPatientsAdd(Patients patiets) {
		
		return patientsRepo.isPatientsAdd(patiets);
	}
	@Override
	public List<Patients> getAllPatients() {
	
		return patientsRepo.getAllPatients();
	}

}
