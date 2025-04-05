package com.techhub.hms.Services;

import java.util.List;

import com.techhub.hms.Models.Patients;

public interface patientsService {
	
	public boolean isPatientsAdd(Patients patiets);
	public List<Patients> getAllPatients();
	public boolean updatePatientById(int id, Patients patients);
	public List<Patients> searchPatientsByName(String patients_name);

}
