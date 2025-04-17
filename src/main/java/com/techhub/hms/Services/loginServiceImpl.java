package com.techhub.hms.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.hms.Models.LoginRequest;
import com.techhub.hms.Repository.DoctorRepository;
import com.techhub.hms.Repository.ReceptionistRepository;
import com.techhub.hms.Repository.patientsRepository;

@Service
public class loginServiceImpl {
	@Autowired
	private patientsRepository patientRepo;
	
	@Autowired
	private ReceptionistRepository  receptionistRepo;
	
	@Autowired
	private DoctorRepository doctorRepo;
	
	
	public Object loginUser(LoginRequest request)
	{
		  String role = request.getRole().toLowerCase();
	        String username = request.getUsername();
	        String password = request.getPassword();
	        switch (role) {
            case "receptionist":
                return receptionistRepo.findByUsernameAndPassword(username, password)
                        .orElseThrow(() -> new RuntimeException("Invalid receptionist credentials"));

            case "doctor":
                return doctorRepo.findByNameAndContact(username, password)
                        .orElseThrow(() -> new RuntimeException("Invalid doctor credentials"));

            case "patient":
                return patientRepo.findByNameAndMobile(username, password)
                        .orElseThrow(() -> new RuntimeException("Invalid patient credentials"));

            default:
                throw new RuntimeException("Invalid role specified");
        }
		
	}

}
