package com.techhub.hms.Services;

import java.util.List;

import com.techhub.hms.Models.Patients;
import com.techhub.hms.Models.Receptionist;

public interface ReceptionistService {
	public boolean isReceptionistAdd(Receptionist receptionist);
	public List<Receptionist> GetAllReceptionist();
	public boolean updateRecById(int id, Receptionist receptionist);
	public List<Receptionist> searchReceptionistByName(String receptionist_name);
	public boolean isdeleteReceptionist(int id); 

	

}
