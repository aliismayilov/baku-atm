package com.safaroff.bakuatm.models;

import java.util.List;

public class Bank {
	public String name;
	public List<ATM> atms;
	
	public Bank(String name, List<ATM> ATMs) {
		this.name = name;
	}
}
