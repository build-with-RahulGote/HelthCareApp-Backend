package com.techhub.hms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.hms.Models.MedicalCertificate;
import com.techhub.hms.Models.Pharmacy;
import com.techhub.hms.Repository.PharmacyRepository;

@Service
public class PharmacyServiceimp implements PharmacyService{
	@Autowired
	PharmacyRepository PharmacyRepo;

	@Override
	public boolean isAddPharmacy(Pharmacy pharmacy) {
		// TODO Auto-generated method stub
		return PharmacyRepo.addPharmacy(pharmacy);
	}

	@Override
	public List<Pharmacy> getAllPharmacy() {
		// TODO Auto-generated method stub
		return PharmacyRepo.getAllPharmacy();
	}

	@Override
	public List<Pharmacy> searchPharmacy(String name) {
		
		return PharmacyRepo.Searchmedicine(name);
	}

	@Override
	public boolean isupdatepharmacy(int id, Pharmacy pharmacy) {
		
		return PharmacyRepo.isUpdatePharmacy(id, pharmacy);
	}

	@Override
	public boolean isDeletepharmacy(int id) {
		
		return PharmacyRepo.isDeletePharmacy(id);
	}

	@Override
	public boolean isAddMedicaleCertificate(MedicalCertificate medi) {
		
		return PharmacyRepo.isAddMedicaleCertificate(medi);
	}

	@Override
	public List<MedicalCertificate> getCertificate() {
		
		return PharmacyRepo.getCertificate();
	}

}
