package com.techhub.hms.Repository;

import java.util.List;

import com.techhub.hms.Models.Pharmacy;

public interface PharmacyRepository {

	public boolean addPharmacy(Pharmacy pharmacy);
	public List<Pharmacy> getAllPharmacy();
	public List<Pharmacy> Searchmedicine(String name);
	public boolean isUpdatePharmacy(int id,Pharmacy pharmacy);
	public boolean isDeletePharmacy(int id);
	

	


}
