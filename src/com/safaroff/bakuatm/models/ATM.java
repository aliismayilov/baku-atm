package com.safaroff.bakuatm.models;

import com.google.android.gms.maps.model.LatLng;

public class ATM {
	public String shortAddress;
	public String longAddress;
	public LatLng latLng;
	
	public Bank bank;
	
	public ATM(String shortAddress, String longAddress, Bank bank, LatLng latLng) {
		this.shortAddress = shortAddress;
		this.longAddress = longAddress;
		this.bank = bank;
		this.latLng = latLng;
	}
	
	@Override
	public String toString() {
		return longAddress;
	}
}
