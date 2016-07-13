package com.sr.phone07.manage;

import java.util.HashSet;
import java.util.Iterator;

import com.sr.phone07.exception.MenuChoiceException;
import com.sr.phone07.info.PhoneCompanyInfo;
import com.sr.phone07.info.PhoneInfo;
import com.sr.phone07.info.PhoneUnivInfo;
import com.sr.phone07.menu_if.INPUT_SELECT;

public class PhoneBookManager {
	// final int MAX_CNT = 100;
	// PhoneInfo[] infoStorage = new PhoneInfo[MAX_CNT];
	// int curCnt = 0;

	HashSet<PhoneInfo> infoStorage = new HashSet<PhoneInfo>();
	static PhoneBookManager inst = null;

	public PhoneBookManager() {
	}

	public PhoneBookManager createManagerInst() {
		if (inst == null) {
			inst = new PhoneBookManager();
		}
		return inst;
	}

	private PhoneInfo readFriendInfo() {

		System.out.print("�̸� : ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.keyboard.nextLine();

		return new PhoneInfo(name, phone);
	}

	private PhoneInfo readUnivFriendInfo() {

		System.out.print("�̸� : ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("���� : ");
		String major = MenuViewer.keyboard.nextLine();
		System.out.print("�г� : ");
		int year = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();

		return new PhoneUnivInfo(name, phone, major, year);
	}

	private PhoneInfo readCompanyFriendInfo() {
		System.out.print("�̸� : ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("ȸ�� : ");
		String company = MenuViewer.keyboard.nextLine();

		return new PhoneCompanyInfo(name, phone, company);

	}

	public void inputData() throws MenuChoiceException {
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.println("1. �Ϲ�, 2. ����, 3. ȸ��");
		System.out.print("���� >> ");

		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		PhoneInfo info = null;

		if (choice < INPUT_SELECT.NORMAL || choice > INPUT_SELECT.COMPANY) {
			throw new MenuChoiceException(choice);
		}

		switch (choice) {
		case INPUT_SELECT.NORMAL:
			info = readFriendInfo();
			break;
		case INPUT_SELECT.UNIV:
			info = readUnivFriendInfo();
			break;
		case INPUT_SELECT.COMPANY:
			info = readCompanyFriendInfo();
			break;
		}
		// infoStorage[curCnt++] = info;
		boolean isAdded = infoStorage.add(info);
		if (isAdded == true) {
			System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�. \n");
		} else {
			System.out.println("�̹� ����� �������Դϴ�. \n");
		}
		// System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�. \n");
	}

	private PhoneInfo search(String name) {
		/*
		 * for (int idx = 0; idx < curCnt; idx++) { PhoneInfo curInfo =
		 * infoStorage[idx]; if (name.compareTo(curInfo.getName()) == 0) {
		 * return idx; } } return -1;
		 */
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if (name.compareTo(curInfo.getName()) == 0) {
				return curInfo;
			}
		}
		return null;

	}

	// public void allData() {
	// System.out.println("��� ������ ���");
	// // for (PhoneInfo idx : infoStorage) {
	// // infoStorage[idx].showPhoneInfo();
	// // }
	// for (int i = 0; i < infoStorage.length; i++) {
	// if (infoStorage[i] != null) {
	// infoStorage[i].showPhoneInfo();
	// } else {
	// break;
	// }
	// }
	// }

	public void searchData() {
		System.out.println("������ �˻��� �����մϴ�..");

		System.out.print("�̸� : ");
		String name = MenuViewer.keyboard.nextLine();
		/*
		 * int dataIdx = search(name); if (dataIdx < 0) {
		 * System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�. \n");
		 * 
		 * } else { infoStorage[dataIdx].showPhoneInfo();
		 * System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�. \n"); }
		 */
		PhoneInfo info = search(name);
		if (info == null) {
			System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�. \n");

		} else {
			info.showPhoneInfo();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�. \n");
		}
	}

	public void deleteData() {
		System.out.println("������ ������ �����մϴ�..");

		System.out.println("�̸� : ");
		String name = MenuViewer.keyboard.nextLine();
		/*
		 * int dataIdx = search(name); if (dataIdx < 0) {
		 * System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�. \n"); } else {
		 * 
		 * for (int idx = dataIdx; idx < (curCnt - 1); idx++) { infoStorage[idx]
		 * = infoStorage[idx + 1]; } curCnt--;
		 * System.out.println("������ ������ �Ϸ� �Ǿ����ϴ�. \n");
		 * 
		 * }
		 */

		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if (name.compareTo(curInfo.getName()) == 0) {
				itr.remove();
				System.out.println("�����Ͱ� ������ �Ϸ�Ǿ����ϴ�. \n");
				return;
			}
		}
		System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�. \n");

	}

}
