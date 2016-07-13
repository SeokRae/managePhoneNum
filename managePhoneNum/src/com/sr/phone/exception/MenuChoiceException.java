package com.sr.phone.exception;

public class MenuChoiceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3905695065504094888L;
	int wrongChoice;

	public MenuChoiceException(int choice) {
		super("잘못된 선택이 이루어졌습니다.");
		wrongChoice = choice;

	}

	public void showWrongChoice() {
		System.out.println(wrongChoice + " 에 해당하는 선택은 존재하지 않습니다.");
	}
}
