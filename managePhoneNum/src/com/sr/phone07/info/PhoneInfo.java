package com.sr.phone07.info;

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

	public int hashCode() {
		return name.hashCode();
	}

	public boolean equals(Object obj) {
		PhoneInfo cmp = (PhoneInfo) obj;
		if (name.compareTo(cmp.name) == 0) {
			return true;
		} else {
			return false;
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
