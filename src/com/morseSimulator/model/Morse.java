package com.morseSimulator.model;

public class Morse {
	private String[][] table = {
			// Lettres
			{"a", ".-"},{"b", "-..."},{"c", "-.-."},{"d", "-.."},{"e", "."},{"f", "..-."},{"g", "--."},{"h", "...."},{"i", ".."},
			{"j", ".---"},{"k", "-.-"},{"l", ".-.."},{"m","--"},{"n", "-."},{"o", "---"},{"p", ".--."},{"q", "--.-"},{"r", ".-."},
			{"s", "..."},{"t", "-"},{"u", "..-"},{"v", "...-"},{"w", ".--"},{"x", "-..-"},{"y", "-.--"},{"z", "--.."},
			// Chiffres
			{"1", ".----"},{"2", "..---"},{"3", "...--"},{"4", "....-"},{"5", "....."},
			{"6", "-...."},{"7", "--..."},{"8", "---.."},{"9", "----."},{"0", "-----"},
			// Espace 
			{" ", "/"},
			// Ponctuation
			{".", ".-.-.-"},{",","--..--"},{"?","..--.."},{"'",".----."},{"!","-.-.--"},{"/","-..-."},
			{"(","-.--."},{")","-.--.-"},{"&",".-..."},{":","---..."},{";","-.-.-."},{"=","-...-"},
			{"+",".-.-."},{"-","-....-"},{"_","..--.-"},{"\"",".-..-."},{"$","...-..-"},
			// Caractères spéciaux
			{"ch", "----"},{"à",".--.-"},{"ç","-.-.."},{"è",".-..-"},{"é","..-.."},{"@",".--.-."},{"\n","\n"}};
	
	public Morse() {
		
	}
	
	public String findMorseChar(String l){
		String m = "";
		if(m.equals(l)) return m;
		for (int i = 0 ; i<table.length ; i++ ) {
			if(l.equals(table[i][0])) {
				m = table[i][1];
			}
		}
		if(m.equals("")) {
			return l;
		}
		return m;
	}
	
	public String findLatinChar(String m) {
		String l = "";
		if(m.equals(l)) return m;
		for (int i = 0 ; i<table.length ; i++ ) {
			if(m.equals(table[i][1])) {
				l = table[i][0];
			}
		}
		if(l.equals("")) {
			return m;
		}
		return l;
	}
	
	/*// L’espacement entre les lettres d’un mot a pour longueur un « taah » (3 « ti »). Il se note par un espace
	// EXEMPLE -.-. --- -.. . / -- --- .-. ... . (CODE MORSE)
	// https://fr.wikipedia.org/wiki/Code_Morse_international
	// ti = 500ms
	// ta = 2000ms
	// 2000ms entre chq lettres
	// 5000ms entre chq mots*/

	public String notRecognizedChar(String s) {
		/*for(int i = 0; i < s.) {
			
		}*/
		return "";
	}
	


	public String[][] getTable(){
		return this.table;
	}

}
