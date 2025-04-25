package com.techhub.hms.Models;

import lombok.Data;

@Data
public class Checkup {
private int checkupid;
private int appointment_id;
private String patientName;
private String  symptoms;
private String medicine;
private String tests_suggested;
private int patient_id;

}
