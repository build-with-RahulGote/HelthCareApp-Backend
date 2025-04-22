package com.techhub.hms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.hms.Models.Appointment;
import com.techhub.hms.Repository.AppointmentRepo;

@Service
public class AppointmentServiceimp implements AppointmentService{
	@Autowired
	AppointmentRepo appointmentrepo;

	@Override
	public boolean isAddAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointmentrepo.isAddAppointment(appointment);
	}

	@Override
	public List<Appointment> getAllAppointment() {
		// TODO Auto-generated method stub
		return appointmentrepo.getAllAppointment();
	}



}
