package com.morseSimulator.observer;

public interface Observable {
	public void addObserver(Observer obs);
	public void notifyObserver();
	public void deleteObserver();
	public void switchTranslationMode();
	public void notifyManualMorse();
}
