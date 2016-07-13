package com.sr.phone08.control;

import com.sr.phone08.exception.MenuChoiceException;
import com.sr.phone08.manage.MenuViewer;
import com.sr.phone08.manage.PhoneBookManager;
import com.sr.phone08.menu_if.INIT_MENU;

public class PhoneBookVer08 {

	public static void main(String[] args) {
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		int choice;

		while (true) {
			try {
				MenuViewer.showMenu();
				choice = MenuViewer.keyboard.nextInt();
				MenuViewer.keyboard.nextLine();
				// ex) 7 + enter
				// nextInt�� ���� 7�� ��������.
				// nextLine�� ���� enter�� ������ �Ŀ� ������
				// �ᱹ nextLine�� enterŰ�� �о���� ������ �����͸� �д� �޼ҵ�

				if (choice < INIT_MENU.INPUT || choice > INIT_MENU.EXIT) {
					throw new MenuChoiceException(choice);
				}
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
					manager.storeToFile();
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
