package com.sr.phone.info;

public class PhoneInfo {

	private String name;
	String phoneNumber;

	public PhoneInfo(String name, String num) {
		this.setName(name);
		phoneNumber = num;
	}

	public void showPhoneInfo() {
		System.out.println("name : " + getName());
		System.out.println("Phone : " + phoneNumber);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
