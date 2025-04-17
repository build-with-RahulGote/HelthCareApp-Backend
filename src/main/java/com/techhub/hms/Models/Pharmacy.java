package com.techhub.hms.Models;

import lombok.Data;

@Data
public class Pharmacy {
	private int medicine_id;
	private String name;
	private String	stock;
	private double price;
	private String	symptoms;


}
