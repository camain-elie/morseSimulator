package com.morseSimulator.view;

import com.morseSimulator.model.Model;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = new Model();
		Screen sc = new Screen(model);
		//model.addObserver(sc);
		sc.setVisible(true);
		/*Translator t = new Translator();
		t.latinToMorse("abc");*/
	}

}
