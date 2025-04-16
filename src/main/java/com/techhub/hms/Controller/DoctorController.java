package com.techhub.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.hms.Exception.patientsNotFoundException;
import com.techhub.hms.Models.Doctor;

import com.techhub.hms.Services.doctorServices;

@CrossOrigin(origins="http://localhost:5173")
@RestController
public class DoctorController {
	@Autowired
	doctorServices doctorserv;
	
	
	@PostMapping("/createDoctor")

	public String createDoctor(@RequestBody Doctor doctor)
	{
		boolean b=doctorserv.isDoctorAdd(doctor);
		if(b) {
			return "Doctor Added Succefully";
		}
		else {
		return "Doctor Not Added";
		}
		
	}
	
	
	@GetMapping("/getAllDoctors")
	public List<Doctor>showDoctors()
	{
		 List<Doctor>list=doctorserv.getAllDoctors();
			if(list.size()!=0)
			{
				return list;
			}
			else
			{
			   throw new patientsNotFoundException("Data Not Avilable in Database");
			}
		
	}
	
	
	@PutMapping("updatedoctor/{id}")
    public String updatedoctors(@PathVariable int id,@RequestBody Doctor doctor)
    {
   	 boolean isupdate=doctorserv.isupdate(id, doctor);
		return isupdate?"Doctor updated successfully!" : "Doctor update failed!";
   	 
    }
	
	
	@GetMapping("/deletedoctor/{id}")
	public String deleteDoctorByid(@PathVariable("id") Integer id )
	{
		boolean b=doctorserv.isdelete(id);
		if(b)
		{
			return "Doctor Deleted";
		}
		else
		{
			throw new patientsNotFoundException("Patient not Found using:"+" "+id);
		}
	}

}
