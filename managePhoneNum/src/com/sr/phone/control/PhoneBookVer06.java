package com.sr.phone.control;

import com.sr.phone.exception.MenuChoiceException;
import com.sr.phone.manage.MenuViewer;
import com.sr.phone.manage.PhoneBookManager;
import com.sr.phone.menu_if.INIT_MENU;

public class PhoneBookVer06 {

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager();
		int choice;

		while (true) {
			try {
				// 메뉴 메소드 호출
				MenuViewer.showMenu();
				// 메뉴 선택을 위한 Scanner 사용
				choice = MenuViewer.keyboard.nextInt();
				// Scanner 입력 시
				// 숫자 + enterKey에서 enterKey를 제거 하기 위한 nextLine();
				MenuViewer.keyboard.nextLine();
				// 사용자가 입력한 숫자가 메뉴 범위 밖의 선택일 경우
				// 예외처리
				if (choice < INIT_MENU.INPUT || choice > INIT_MENU.EXIT) {
					throw new MenuChoiceException(choice);
				}
				// 입력된 숫자가 메뉴 범위 내에 입력일 경우
				// 조건문 실행
				switch (choice) {
				case INIT_MENU.INPUT:
					manager.inputData();
					break;
				case INIT_MENU.SEARCH:
					manager.searchData();
					break;
				case INIT_MENU.DELITE:
					manager.deleteData();
					break;
				case INIT_MENU.EXIT:
					System.out.println("���α׷��� ���� �մϴ�.");
					return;
				}
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�.");
			}
		}
	}
}
