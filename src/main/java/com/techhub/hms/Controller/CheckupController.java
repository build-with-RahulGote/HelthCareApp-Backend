package com.techhub.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.hms.Exception.patientsNotFoundException;
import com.techhub.hms.Models.Appointment;
import com.techhub.hms.Models.Checkup;
import com.techhub.hms.Services.CheckupService;
@CrossOrigin(origins="http://localhost:5173")
@RestController
public class CheckupController {

	@Autowired
	CheckupService checkupService;
	
	@PostMapping("/createpricription")
	public String createPerciription(@RequestBody Checkup chekup)
	{
		boolean b=checkupService.isAddPrecription(chekup);
		if(b) {
			return "Prescription  Added Succefully";
		}
		else {
		return "Prescription  Not Added";
		}
		
	}
	
	
	
	
	@GetMapping("/getAllPericription")
	public List<Checkup>showPericription()
	{
		 List<Checkup>list=checkupService.getAllPrecription();
			if(list.size()!=0)
			{
				return list;
			}
			else
			{
			   throw new patientsNotFoundException("Data Not Avilable in Database");
			}
	
	}
	
	@GetMapping("getprescription/{patientId}")
	public ResponseEntity<List<Checkup>> getCheckupsByPatientId(@PathVariable int patientId) {
	    List<Checkup> details = checkupService.getCheckupDetailsByPatientId(patientId);
	    return ResponseEntity.ok(details);
	}
	
	
	
}

