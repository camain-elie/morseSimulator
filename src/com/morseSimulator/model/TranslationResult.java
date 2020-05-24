package com.morseSimulator.model;

public class TranslationResult {
	private String translatedString;
	private String errorString;
	
	public TranslationResult(String translatedString) {
		this.setTranslatedString(translatedString);
		this.setErrorString("");
	}
	
	public TranslationResult(String translatedString, String errorString) {
		this.setTranslatedString(translatedString);
		this.setErrorString(errorString);
	}

	public String getTranslatedString() {
		return translatedString;
	}

	public void setTranslatedString(String translatedString) {
		this.translatedString = translatedString;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}
	

}
