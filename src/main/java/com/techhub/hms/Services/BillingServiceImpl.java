package com.techhub.hms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.hms.Models.Billing;
import com.techhub.hms.Repository.BillingRepo;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	BillingRepo billingrepo;

	@Override
	public boolean isAddBill(Billing billing) {
		
		return billingrepo.isAddBill(billing);
	}

	@Override
	public List<Billing> getAllBills() {
		
		return billingrepo.getAllBills();
	}

	@Override
	public List<Billing> getallbillsById(int patients_id) {
		
		return billingrepo.getallbillsById(patients_id);
	}

	@Override
	public List<Billing> getAllBillsWithPatientName() {
		
		return billingrepo.getAllBillsWithPatientName();
	}

	@Override
	public int updatePaymentMode(int billId, String paymentMode) {
		
		return billingrepo.updatePaymentMode(billId, paymentMode);
	}

	@Override
	public Billing getBillById(int id) {
		
		return billingrepo.getBillById(id);
	}
}
