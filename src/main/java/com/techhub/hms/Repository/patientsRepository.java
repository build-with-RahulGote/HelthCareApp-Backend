package com.techhub.hms.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.techhub.hms.Models.Patients;
import com.techhub.hms.Models.Pharmacy;

public interface patientsRepository {
	public boolean isPatientsAdd(Patients patiets);
	public List<Patients> getAllPatients();
	public boolean updatePatientById(int id, Patients patients);
	public List<Patients> searchPatientsByName(String patients_name);
	public boolean isDeletePatients(int id);
	Optional<Map<String, Object>> findByNameAndMobile(String name, String mobile);

	
}
