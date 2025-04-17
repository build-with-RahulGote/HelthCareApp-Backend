package com.techhub.hms.Services;

import java.util.List;

import com.techhub.hms.Models.Appointment;

public interface AppointmentService {
	public boolean isAddAppointment(Appointment appointment);
	public List<Appointment> getAllAppointment();
	public boolean isupdate(int id, Appointment appointment);
	public List<Appointment> SearchAppointment(String name);
	public boolean isDeleteAppointment(int id);


}
