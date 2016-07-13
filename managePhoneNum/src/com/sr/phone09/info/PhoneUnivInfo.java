package com.sr.phone09.info;

public class PhoneUnivInfo extends PhoneInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6013237453339352352L;

	String major;
	int year;

	public PhoneUnivInfo(String name, String num, String major, int year) {
		super(name, num);
		this.major = major;
		this.year = year;
	}

	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("major : " + major);
		System.out.println("year : " + year);

	}

	@Override
	public String toString() {
		return "PhoneUnivInfo [major=" + major + ", year=" + year + "]";
	}

}
