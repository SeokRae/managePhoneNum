package com.sr.phone09.info;

public class PhoneCompanyInfo extends PhoneInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9199150854953714550L;
	String company;

	public PhoneCompanyInfo(String name, String num, String company) {
		super(name, num);
		this.company = company;

	}

	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("company : " + company);
	}

	@Override
	public String toString() {
		return "PhoneCompanyInfo [company=" + company + "]";
	}

}
