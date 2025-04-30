package com.techhub.hms.Repository;

import java.util.List;

import com.techhub.hms.Models.Billing;

public interface BillingRepo {
	public boolean isAddBill(Billing billing);
	public List<Billing> getAllBills();
	public List<Billing>getallbillsById(int patients_id);
	public List<Billing> getAllBillsWithPatientName();
	public int updatePaymentMode(int billId, String paymentMode);
	 public Billing getBillById(int  id);
}
