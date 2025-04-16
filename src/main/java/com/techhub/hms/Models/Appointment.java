package com.techhub.hms.Models;

import java.sql.Date;

import lombok.Data;
@Data
public class Appointment {
private int appointment_id;
private int patient_id;
private Date Appointment_date;
private String time;
private String Status;
}
