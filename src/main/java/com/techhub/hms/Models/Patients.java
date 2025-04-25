package com.techhub.hms.Models;

import java.util.Date;



import lombok.Data;

@Data
public class Patients {
	private int patientId;
	private String name;
	private String gender;
	private Date dob;
	private String maritalstatus;
	private String address;
	private String email;
	private String wpnumber;
	private String mobailenumber;
	

}
