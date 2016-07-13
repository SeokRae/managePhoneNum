package com.sr.phone09.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sr.phone09.manage.PhoneBookManager;

public class SearchEventHandler implements ActionListener {
	JTextField searchField;
	JTextArea textArea;

	public SearchEventHandler(JTextField field, JTextArea area) {
		searchField = field;
		textArea = area;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name = searchField.getText();
		PhoneBookManager manager = PhoneBookManager.createManagerInst();

		String srchResult = manager.searchData(name);
		if (srchResult == null) {
			textArea.append("해당하는 데이터가 존재하지 않습니다. \n");
		} else {
			textArea.append("찾으시는 정보를 알려드립니다. \n");
			textArea.append(srchResult);
			textArea.append("\n");
		}

	}

}
