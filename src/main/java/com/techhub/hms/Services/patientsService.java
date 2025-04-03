package com.techhub.hms.Services;

import java.util.List;

import com.techhub.hms.Models.Patients;

public interface patientsService {
	
	public boolean isPatientsAdd(Patients patiets);
	public List<Patients> getAllPatients();

}
