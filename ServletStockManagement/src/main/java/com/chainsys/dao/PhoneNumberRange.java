package com.chainsys.dao;

public class PhoneNumberRange extends Exception {

	public PhoneNumberRange(String str) {
		System.err.println("Phone Number Must Contain Ten Numbers!");
	}
}
