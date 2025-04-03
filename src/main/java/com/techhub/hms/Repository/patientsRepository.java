package com.techhub.hms.Repository;

import java.util.List;

import com.techhub.hms.Models.Patients;

public interface patientsRepository {
	public boolean isPatientsAdd(Patients patiets);
	public List<Patients> getAllPatients();

}
