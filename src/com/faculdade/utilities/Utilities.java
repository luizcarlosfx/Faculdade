package com.faculdade.utilities;

public class Utilities {
	public static String firstCharatereUpperCase(String string) {
		String novaString = "";
		novaString += string.toUpperCase().charAt(0);
		novaString += string.substring(1);
		return novaString;
	}
}
