package com.techhub.hms.Repository;

import java.util.List;

import com.techhub.hms.Models.Doctor;

public interface DoctorRepository {
	public boolean isDoctorsAdd(Doctor doctor);
	public List<Doctor> getAllDoctors();
	public boolean isupdate(int id,Doctor doctor);
}
