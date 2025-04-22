package com.techhub.hms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}

