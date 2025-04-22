package com.techhub.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.hms.Exception.patientsNotFoundException;
import com.techhub.hms.Models.Patients;
import com.techhub.hms.Models.Pharmacy;
import com.techhub.hms.Services.PharmacyService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
public class PharmacyController {
	@Autowired
	PharmacyService  PharmacyS;
	
	@PostMapping("/CreatePharmacy")
	public String isAddPharmacy(@RequestBody Pharmacy pharmacy) {
		boolean b=PharmacyS.isAddPharmacy(pharmacy);
		if(b) {
			return "Pharmacy Add Sucessfully";
		}else {
			return "Pharmacy Not Added";
		}
	}
     
	@GetMapping("/ViewAllPharmacy")
	public List<Pharmacy> getAllPharmacy(){
		List<Pharmacy> list=PharmacyS.getAllPharmacy();
		if(list.size()!=0) {
			return list;
			
		}else {
			throw new patientsNotFoundException("Data Not Avilable in Database");
		}
	}
	@GetMapping("/searchPharmacyName/{name}")
	public ResponseEntity<List<Pharmacy>> searchPharmacybyname(@PathVariable("name") String name) {
	
	    List<Pharmacy> list = PharmacyS.searchPharmacy(name);

	    if (!list.isEmpty()) {
	        return ResponseEntity.ok(list);
	    } else {
	        throw new patientsNotFoundException("PharmacyS with name '" + name + "' not found in the database.");
	    }
	}
	@PutMapping("/isupdatePharmacy/{id}")
	public String isupdatePharmacy(@PathVariable int id,@RequestBody Pharmacy pharmacy) {
		boolean b=	PharmacyS.isupdatepharmacy(id, pharmacy);
		if(b) {
			return "Pharmacy Updated sucessfully";
		}else {
			 throw new patientsNotFoundException("Pharmacy with name '" +pharmacy + "' not found in the database.");
	    
		}
	}
	@DeleteMapping("/isDelate/{id}")
	public String isDelatePharmacy(@PathVariable("id")Integer id) {
		boolean b=PharmacyS.isDeletepharmacy(id);
		if(b) {
			return "Pharmacy Delete Sucessfully";
		}else {
			throw new patientsNotFoundException("Patient not Found using:"+" "+id);
		}
		
	}
}
