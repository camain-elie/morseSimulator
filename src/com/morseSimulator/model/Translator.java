package com.morseSimulator.model;

public class Translator {
	private Morse morse = new Morse();
	
	
	
	public Translator() {
		
	}
	
	public TranslationResult latinToMorse(String latin) {
		String morseString ="", errorString = "", previousChar = "", morseChar;
		while(latin.length()>0) {
			morseChar = this.morse.findMorseChar(latin.substring(0,1));
			if(morseChar.equals("\n") || previousChar.equals("\n")) {
				morseString = morseString + morseChar;
			}else {
				morseString = morseString + " " + this.morse.findMorseChar(latin.substring(0,1));
			}
			previousChar = morseChar;
			if(latin.substring(0,1).equals(morseChar) && !morseChar.equals("\n"))
				errorString = errorString + ", " + morseChar;
			latin = latin.substring(1, latin.length());
		}
		morseString = morseString.substring(1, morseString.length());
		if(errorString.length()>0)
			errorString = errorString.substring(2,errorString.length());
		return new TranslationResult(morseString, errorString);
	}
	
	
	
	
	
	public TranslationResult morseToLatin(String morse) {	
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
