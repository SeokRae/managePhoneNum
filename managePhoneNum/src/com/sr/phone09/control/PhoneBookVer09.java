package com.sr.phone09.control;

import com.sr.phone09.exception.MenuChoiceException;
import com.sr.phone09.gui.SearchDelFrame;
import com.sr.phone09.manage.MenuViewer;
import com.sr.phone09.manage.PhoneBookManager;
import com.sr.phone09.menu_if.INIT_MENU;

public class PhoneBookVer09 {

	public static void main(String[] args) {
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		SearchDelFrame winFrame = new SearchDelFrame("PhoneBookVer09");
		int choice;

		while (true) {
			try {
				MenuViewer.showMenu();
				choice = MenuViewer.keyboard.nextInt();
				MenuViewer.keyboard.nextLine();
				// ex) 7 + enter
				// nextInt를 통해 7이 읽혀진다.
				// nextLine을 통해 enter가 읽혀진 후에 버려짐
				// 결국 nextLine은 enter키를 읽어들일 때까지 데이터를 읽는 메소드

				if (choice < INIT_MENU.INPUT || choice > INIT_MENU.EXIT) {
					throw new MenuChoiceException(choice);
				}
				switch (choice) {
				case INIT_MENU.INPUT:
					manager.inputData();
					break;
				case INIT_MENU.EXIT:
					manager.storeToFile();
					System.out.println("프로그램을 종료 합니다.");
					System.exit(0);
					return;
				}
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
			}
		}
	}
}
