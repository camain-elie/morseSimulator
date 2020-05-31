package com.morseSimulator.model;

/**
 * Translator is a set tools that let the user translate a String written in the latin alphabet into a String written with the morse alphabet.
 * @author Elie
 *
 */
public class Translator {
	private Morse morse = new Morse();
	
	
	
	public Translator() {
		
	}
	
	public TranslationResult latinToMorse(String latin) {
		String morseString ="", errorString = "", previousChar = "", morseChar;
		while(latin.length()>0) {
			morseChar = this.morse.findMorseChar(latin.substring(0,1));
			if(morseChar.equals("\n") || previousChar.equals("\n") || morseChar.equals("	")) {
				morseString = morseString + morseChar;
			}else {
				morseString = morseString + " " + morseChar;
			}
			previousChar = morseChar;
			if(latin.substring(0,1).equals(morseChar) && !morseChar.equals("\n") && !morseChar.equals("	"))
				errorString = errorString + ", " + morseChar;
			latin = latin.substring(1, latin.length());
		}
		if(morseString.length()>0)
			morseString = morseString.substring(1, morseString.length());
		if(errorString.length()>0)
			errorString = errorString.substring(2,errorString.length());
		return new TranslationResult(morseString, errorString);
	}
	
	
	/**
	 * 
	 * @param morse
	 * @return
	 */
	public TranslationResult morseToLatin(String morse) {
		//TODO Multiple spaces counted as errors
		String latinString = "", temporary = "", errorString = "";
		String[] lineSplit = morse.split("\n");
		for(int i = 0; i < lineSplit.length; i++) {
			String[] spaceSplit = lineSplit[i].split(" ");
			for(int j = 0; j < spaceSplit.length; j++) {
				System.out.println();
				temporary = this.morse.findLatinChar(spaceSplit[j]);
				if(!temporary.equals(spaceSplit[j]) || temporary.equals("\n") || temporary.equals(" ") || temporary.equals("	")) {
					latinString += temporary;
				}else{
					if(temporary.equals("")) {
						latinString += " ";
					}else{
						errorString += ", " + temporary;
					}
				}
			}
			latinString += "\n";
		}
		if(errorString.length()>0) {
			errorString = errorString.substring(2,errorString.length());
		}
		System.out.println("." + errorString + ".");
		return new TranslationResult(latinString,errorString);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
