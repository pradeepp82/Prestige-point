package com.aartek.prestigepoint.util;

public class CamelCase {
	
	  public static String produceCamelCase(String input) {
		    String inputstring = input.toLowerCase();
		    String[] parts = inputstring.split(" ");
		    String s ="";
		    for (int i=0; i<parts.length; ++i) {
		       s=s+" "+parts[i].substring(0,1).toUpperCase()+parts[i].substring(1);
		    }
		    return s.trim();
	    }
}
