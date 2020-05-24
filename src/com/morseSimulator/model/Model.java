package com.morseSimulator.model;

import java.util.ArrayList;

import com.morseSimulator.observer.Observable;
import com.morseSimulator.observer.Observer;

public class Model implements Observable{
	private Translator translate = new Translator();
	private String input = new String("");
	private String output = new String("");
	private boolean toMorse = true;
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	public Model(Observer obs) {
		this.listObserver.add(obs);
	}
	
	public void translate() {
		
	}
	
	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
	}

	public void notifyObserver() {
		for(Observer obs : listObserver) {
			obs.update("");
		}
	}

	public void deleteObserver() {
		
	}

}
