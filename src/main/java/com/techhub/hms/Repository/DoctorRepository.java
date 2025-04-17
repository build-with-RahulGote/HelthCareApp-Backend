package com.techhub.hms.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.techhub.hms.Models.Doctor;

public interface DoctorRepository {
	public boolean isDoctorsAdd(Doctor doctor);
	public List<Doctor> getAllDoctors();
	public boolean isupdate(int id,Doctor doctor);
	public boolean isdelete(int id);
 public Optional<Map<String, Object>> findByNameAndContact(String name, String contact);
}
