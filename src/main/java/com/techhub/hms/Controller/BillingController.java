package com.techhub.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.hms.Exception.patientsNotFoundException;
import com.techhub.hms.Models.Appointment;
import com.techhub.hms.Models.Billing;
import com.techhub.hms.Services.BillingService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
public class BillingController {

	@Autowired
	BillingService billingService;
	@PostMapping("/createBill")
	public String createBill(@RequestBody Billing billing )
	{
		System.out.println(billing);
		boolean b=billingService.isAddBill(billing);
		if(b)
		{
			return "Bill Added Suceessfully";
		}
		else
		{
			return "Bill Not Added";
		}
		
	}
	
	@GetMapping("/getAllBills")
	public List<Billing>showBills()
	{
		 List<Billing>list=billingService.getAllBills();
			if(list.size()!=0)
			{
				return list;
			}
			else
			{
			   throw new patientsNotFoundException("Data Not Avilable in Database");
			}
	}
	
	@GetMapping("/getbillById/{patients_id}")
	public List<Billing>getBillById(@PathVariable int patients_id)
	{
		List<Billing>list=billingService.getallbillsById(patients_id);
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
