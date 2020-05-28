package com.morseSimulator.observer;

import com.morseSimulator.model.TranslationResult;

public interface Observer {
	public void update(TranslationResult result);
	public void switchTranslation(boolean bool);
}
