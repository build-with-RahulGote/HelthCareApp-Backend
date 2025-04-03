package com.techhub.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.hms.Exception.patientsNotFoundException;
import com.techhub.hms.Models.Patients;
import com.techhub.hms.Services.patientsService;

@RestController
public class PatientsController {
	
	@Autowired
	patientsService patientsserv;

	
	@PostMapping("/createPatients")

	public String createPatients(@RequestBody Patients patients)
	{
		boolean b=patientsserv.isPatientsAdd(patients);
		if(b) {
			return "Patients Added Succefully";
		}
		else {
		return "Patients Not Added";
		}
		
	}
	
	
	@GetMapping("/getAllPatients")
	public List<Patients>showPatients()
	{
		 List<Patients>list=patientsserv.getAllPatients();
			if(list.size()!=0)
			{
				return list;
			}
			else
			{
			   throw new patientsNotFoundException("Data Not Avilable in Database");
			}
		
	}
	 
}
