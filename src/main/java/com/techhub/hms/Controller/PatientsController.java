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
import com.techhub.hms.Models.Patients;
import com.techhub.hms.Services.patientsService;

@CrossOrigin(origins="http://localhost:5173")
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
				 for (Patients p : list) {
				        System.out.println("DOB of patient " + p.getName() + ": " + p.getDob());
				    }

				return list;
			}
			else
			{
			   throw new patientsNotFoundException("Data Not Avilable in Database");
			}
		
	}
	
	
	@PutMapping("update/{id}")
    public String updatepatients(@PathVariable int id,@RequestBody Patients patient)
    {
   	 boolean isupdate=patientsserv.updatePatientById(id, patient);
		return isupdate?"Patient updated successfully!" : "Patient update failed!";
   	 
    }
	
	@GetMapping("searchpatientsByName/{patients}")
	public ResponseEntity<List<Patients>> searchPatientsByName(@PathVariable("patients") String patients) {
	 System.out.println("Patient name:"+""+patients);
	    List<Patients> list = patientsserv.searchPatientsByName(patients);

	    if (!list.isEmpty()) {
	        return ResponseEntity.ok(list);
	    } else {
	        throw new patientsNotFoundException("Patient with name '" + patients + "' not found in the database.");
	    }
	}
	
	@GetMapping("/deleteById/{id}")
	public String deletePatientsByid(@PathVariable("id") Integer id )
	{
		boolean b=patientsserv.isDeletePatients(id);
		if(b)
		{
			return "Patients Deleted";
		}
		else
		{
			throw new patientsNotFoundException("Patient not Found using:"+" "+id);
		}
		
	}
	 
}
