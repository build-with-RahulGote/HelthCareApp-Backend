package com.techhub.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.hms.Exception.patientsNotFoundException;
import com.techhub.hms.Models.Appointment;
import com.techhub.hms.Models.Tests;
import com.techhub.hms.Services.TestService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TestsController {

	@Autowired
	TestService testService;
	
	@PostMapping("/Addtest")
	public String Addtest(@RequestBody Tests test)
	{
		boolean b=testService.isTestAdded(test);
		if(b)
		{
			return "Test Added Successfully";
		}
		else
		{
			return "Test not Added";
		}
	}
	
	@GetMapping("/getTest")
	public List<Tests>showAllTests()
	{
		 List<Tests>list=testService.getTests();
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
