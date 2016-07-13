package com.sr.phone07.control;

import com.sr.phone07.exception.MenuChoiceException;
import com.sr.phone07.manage.MenuViewer;
import com.sr.phone07.manage.PhoneBookManager;
import com.sr.phone07.menu_if.INIT_MENU;

public class PhoneBookVer07 {

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager();
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
