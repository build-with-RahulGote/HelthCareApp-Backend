package com.techhub.hms.Repository;

import java.util.List;

import com.techhub.hms.Models.Appointment;
import com.techhub.hms.Models.Doctor;
import com.techhub.hms.Models.Pharmacy;

public interface AppointmentRepo {
	public boolean isAddAppointment(Appointment appointment);
	public List<Appointment> getAllAppointment();
	

}
