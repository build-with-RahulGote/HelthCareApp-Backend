package com.techhub.hms.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.techhub.hms.Models.Patients;
import com.techhub.hms.Models.Receptionist;

public interface ReceptionistRepository {
	public boolean isaddReceptionist(Receptionist receptionist);
	public List<Receptionist> GetAllReceptionist();
	public boolean updateReceptionistById(int id, Receptionist receptionist);
	 public List<Receptionist> searchReceptionistByName(String receptionist_name);
	 public  boolean isdeletesReceptionist(int id);
	public Optional<Map<String, Object>> findByUsernameAndPassword(String username, String password) ;
}
