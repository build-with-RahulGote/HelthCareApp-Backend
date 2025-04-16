package com.techhub.hms.Services;



import java.util.List;

import com.techhub.hms.Models.Doctor;


public interface doctorServices {
	public boolean isDoctorAdd(Doctor doctor);
	public List<Doctor> getAllDoctors();
	public boolean isupdate(int id,Doctor doctor);
	public boolean isdelete(int id);

}
