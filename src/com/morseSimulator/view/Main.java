package com.morseSimulator.view;

import com.morseSimulator.model.Model;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		Screen sc = new Screen(model);
		sc.setVisible(true);
	}

}
