package com.safaroff.bakuatm.models;

public class ATM {
	public String shortAddress;
	public String longAddress;
	
	public Bank bank;
	
	public ATM(String shortAddress, String longAddress, Bank bank) {
		this.shortAddress = shortAddress;
		this.longAddress = longAddress;
		this.bank = bank;
	}
}
