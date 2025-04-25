package com.techhub.hms.Services;

import java.util.List;

import com.techhub.hms.Models.Checkup;

public interface CheckupService {
	public boolean isAddPrecription(Checkup checkup);
	public List<Checkup>getCheckupDetailsByPatientId(int patientsId);

}
