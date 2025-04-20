package com.techhub.hms.Services;

import java.util.List;


import com.techhub.hms.Models.Billing;

public interface BillingService {
	public boolean isAddBill(Billing billing);
	public List<Billing> getAllBills();
	public List<Billing>getallbillsById(int patients_id);

}
