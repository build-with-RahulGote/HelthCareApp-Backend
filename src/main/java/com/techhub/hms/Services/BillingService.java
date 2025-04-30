package com.techhub.hms.Services;

import java.util.List;


import com.techhub.hms.Models.Billing;

public interface BillingService {
	public boolean isAddBill(Billing billing);
	public List<Billing> getAllBills();
	public List<Billing>getallbillsById(int patients_id);
	public List<Billing> getAllBillsWithPatientName();
	public int updatePaymentMode(int billId, String paymentMode);
	 public Billing getBillById(int  id);

}
