package com.techhub.hms.Services;

import java.util.List;

import com.techhub.hms.Models.MedicalCertificate;
import com.techhub.hms.Models.Pharmacy;

public interface PharmacyService {

	public boolean isAddPharmacy(Pharmacy pharmacy);
	public List<Pharmacy> getAllPharmacy();
	public List<Pharmacy> searchPharmacy(String name);
	public boolean isupdatepharmacy(int id,Pharmacy pharmacy);
	public boolean isDeletepharmacy(int id);
	public boolean isAddMedicaleCertificate(MedicalCertificate medi);
	public List<MedicalCertificate>getCertificate();
}
