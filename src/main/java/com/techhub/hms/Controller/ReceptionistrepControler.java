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
import com.techhub.hms.Models.Receptionist;
import com.techhub.hms.Services.ReceptionistService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/hms")
public class ReceptionistrepControler {
	@Autowired
	ReceptionistService receptionists;

	@PostMapping("/AddReceptionist")
	public String CreateReceptionistService(@RequestBody Receptionist receptionist) {
		boolean b=receptionists.isReceptionistAdd(receptionist);
		if(b) {
	
			return "receptionists Add Sucessfully";
		}else {
			return "receptionists Not Added";
		}
		
	}
	@GetMapping("/Viewreceptionists")
	public List<Receptionist> showReceptionist(){
		List<Receptionist> list=receptionists.GetAllReceptionist();
		if(list.size()!=0) {
			return list;
		}else {
			throw new patientsNotFoundException("Data Not Avilable in Database");
		}
	
		
	}
	@PutMapping("updateReceptionist/{id}")
    public String updateReceptionist(@PathVariable int id,@RequestBody Receptionist receptionist)
    {
   	 boolean isupdate=receptionists.updateRecById(id, receptionist);
		return isupdate?"Receptionist updated successfully!" : "Receptionist update failed!";
   	 
    }
	@GetMapping("searchReceptionistByName/{Receptionist}")
	public ResponseEntity<List<Receptionist>> searchEmployeeByName(@PathVariable("Receptionist") String Receptionist) {
	 System.out.println("Patient name:"+""+Receptionist);
	    List<Receptionist> list = receptionists.searchReceptionistByName(Receptionist);

	    if (!list.isEmpty()) {
	        return ResponseEntity.ok(list);
	    } else {
	        throw new patientsNotFoundException("Patient with name '" + Receptionist + "' not found in the database.");
	    }
	}

	@DeleteMapping("/DeleteReceptionis/{id}")
	public String DeleteReceptionist(@PathVariable("id")int id) {
		boolean b=receptionists.isdeleteReceptionist(id);
		if(b) {
			return "Receptionist Delete";
			
		}else {
			throw new patientsNotFoundException("Patient with name '" + id + "' not found in the database.");
		}
		
	}
	


}
