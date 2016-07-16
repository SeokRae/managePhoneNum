package com.sr.phone.manage;

import com.sr.phone.exception.MenuChoiceException;
import com.sr.phone.info.PhoneCompanyInfo;
import com.sr.phone.info.PhoneInfo;
import com.sr.phone.info.PhoneUnivInfo;
import com.sr.phone.menu_if.INPUT_SELECT;

public class PhoneBookManager {
	final int MAX_CNT = 100;
	PhoneInfo[] infoStorage = new PhoneInfo[MAX_CNT];
	int curCnt = 0;

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

		System.out.print("이름 : ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.keyboard.nextLine();

		return new PhoneInfo(name, phone);
	}

	private PhoneInfo readUnivFriendInfo() {

		System.out.print("이름 : ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("전공 : ");
		String major = MenuViewer.keyboard.nextLine();
		System.out.print("학년 : ");
		int year = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();

		return new PhoneUnivInfo(name, phone, major, year);
	}

	private PhoneInfo readCompanyFriendInfo() {
		System.out.print("이름 : ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("회사 : ");
		String company = MenuViewer.keyboard.nextLine();

		return new PhoneCompanyInfo(name, phone, company);

	}

	public void inputData() throws MenuChoiceException {
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.print("선택 >> ");

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
		infoStorage[curCnt++] = info;
		System.out.println("데이터 입력이 완료되었습니다. \n");
	}

	private int search(String name) {
		for (int idx = 0; idx < curCnt; idx++) {
			PhoneInfo curInfo = infoStorage[idx];
			if (name.compareTo(curInfo.getName()) == 0) {
				return idx;
			}
		}
		return -1;

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
		System.out.println("데이터 검색을 시작합니다..");

		System.out.print("이름 : ");
		String name = MenuViewer.keyboard.nextLine();

		int dataIdx = search(name);
		if (dataIdx < 0) {
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");

		} else {
			infoStorage[dataIdx].showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다. \n");
		}
	}

	public void deleteData() {
		System.out.println("데이터 삭제를 시작합니다..");

		System.out.println("이름 : ");
		String name = MenuViewer.keyboard.nextLine();

		int dataIdx = search(name);
		if (dataIdx < 0) {
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
		} else {

			for (int idx = dataIdx; idx < (curCnt - 1); idx++) {
				infoStorage[idx] = infoStorage[idx + 1];
			}
			curCnt--;
			System.out.println("데이터 삭제가 완료 되었습니다. \n");

		}
	}

}
