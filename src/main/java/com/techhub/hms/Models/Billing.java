package com.techhub.hms.Models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Billing {
	private int bill_id;
	private int patients_id;
	private double total_amount;
	private String payment_Status;
	private String payment_mode;

}
