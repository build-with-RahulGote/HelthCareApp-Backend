package com.techhub.hms.Models;

import java.sql.Date;

import lombok.Data;
@Data
public class MedicalCertificate {
	private int McId;
	private String patientName;
	private Date dob;
	private String gender;
	private String maritalStatus;
	private String address;
	private String email;
	private String mobileNumber;
	private String certificateType;
	private String reason;
	private Date startDate;
	private Date endDate;
	private String notes;

}
