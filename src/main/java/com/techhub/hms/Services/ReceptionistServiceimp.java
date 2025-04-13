package com.techhub.hms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.hms.Models.Receptionist;
import com.techhub.hms.Repository.ReceptionistRepository;
@Service
public class ReceptionistServiceimp implements ReceptionistService{
	@Autowired
	ReceptionistRepository receptionistrep;
	@Override
	public boolean isReceptionistAdd(Receptionist receptionist) {
		// TODO Auto-generated method stub
		return receptionistrep.isaddReceptionist(receptionist);
	}
	@Override
	public List<Receptionist> GetAllReceptionist() {
		// TODO Auto-generated method stub
		return receptionistrep.GetAllReceptionist();
	}
	@Override
	public boolean updateRecById(int id, Receptionist receptionist) {
		// TODO Auto-generated method stub
		return receptionistrep.updateReceptionistById(id, receptionist);
	}
	@Override
	public List<Receptionist> searchReceptionistByName(String receptionist_name) {
		// TODO Auto-generated method stub
		return receptionistrep.searchReceptionistByName(receptionist_name);
	}
	@Override
	public boolean isdeleteReceptionist(int id) {
		// TODO Auto-generated method stub
		return receptionistrep.isdeletesReceptionist(id);
	}
	
	
	
}
