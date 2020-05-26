package com.morseSimulator.controler;

import com.morseSimulator.model.Model;

public class Controler {
	
	private Model model;
	
	public Controler(Model model) {
		this.model = model;
	}
	
	public void control(String s) {
		System.out.println("control");
		this.model.translate(s);
	}
}
