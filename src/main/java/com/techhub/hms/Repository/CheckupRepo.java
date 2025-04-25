package com.techhub.hms.Repository;

import java.util.List;

import com.techhub.hms.Models.Checkup;

public interface CheckupRepo {
	public boolean isAddPrecription(Checkup checkup);
	public List<Checkup>getCheckupDetailsByPatientId(int patientsId);
}
