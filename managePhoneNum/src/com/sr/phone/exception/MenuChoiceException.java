package com.sr.phone.exception;

public class MenuChoiceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3905695065504094888L;
	int wrongChoice;

	public MenuChoiceException(int choice) {
		super("�߸��� ������ �̷�������ϴ�.");
		wrongChoice = choice;

	}

	public void showWrongChoice() {
		System.out.println(wrongChoice + " �� �ش��ϴ� ������ �������� �ʽ��ϴ�.");
	}
}
