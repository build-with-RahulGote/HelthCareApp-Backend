package com.techhub.hms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.hms.Models.Doctor;
import com.techhub.hms.Repository.DoctorRepository;

@Service
public class doctorServicesImpl  implements doctorServices {
	@Autowired
  DoctorRepository doctorRepo;

	@Override
	public boolean isDoctorAdd(Doctor doctor) {
		
		return doctorRepo.isDoctorsAdd(doctor);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		
		return doctorRepo.getAllDoctors();
	}

	@Override
	public boolean isupdate(int id, Doctor doctor) {
		
		return doctorRepo.isupdate(id, doctor);
	}

	@Override
	public boolean isdelete(int id) {
		
		return doctorRepo.isdelete(id);
	}

	

	
	
	
	
}
