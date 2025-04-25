package com.techhub.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.hms.Exception.patientsNotFoundException;
import com.techhub.hms.Models.Appointment;
import com.techhub.hms.Models.Doctor;
import com.techhub.hms.Models.Patients;
import com.techhub.hms.Services.AppointmentService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
public class AppointmentController {
	@Autowired
	AppointmentService AppointmentS;
	
	@PostMapping("/createAppointment")
	public String createAppointment(@RequestBody Appointment appointmentS)
	{
		boolean b=AppointmentS.isAddAppointment(appointmentS);
		if(b) {
			return "AppointmentS Added Succefully";
		}
		else {
		return "AppointmentS Not Added";
		}
		
	}
	
	
	@GetMapping("/getAllAppointments")
	public List<Appointment>showAppointment()
	{
		 List<Appointment>list=AppointmentS.getAllAppointment();
			if(list.size()!=0)
			{
				return list;
			}
			else
			{
			   throw new patientsNotFoundException("Data Not Avilable in Database");
			}
	
	}
	@PutMapping("updateAppointments/{id}")
    public String updateAppointment(@PathVariable int id,@RequestBody Appointment appointment)
    {
   	 boolean isupdate=AppointmentS.isupdate(id, appointment);
		return isupdate?"Appointment updated successfully!" : "Appointment update failed!";
   	 
    }
	

}
