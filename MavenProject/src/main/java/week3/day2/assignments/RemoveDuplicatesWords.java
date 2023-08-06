package week3.day2.assignments;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesWords {

	public static void main(String[] args) {		
		/*
		 * Pseudo code 
		 * a) Use the declared String text as input	
		 * b) Split the String based on white spaces and save as String Array ,Then iterate the Array	  
		 * c) Create a empty Set 
		 * d) Iterate the String array
	         d.1) add each word into Set
		 * e) Print the Set values which is having unique words
		 */
		
		//a) Use the declared String text as input	
		String text = "We learn java basics as part of java sessions in java week1";

		//b) Split the String based on white spaces and save as String Array ,Then iterate the Array	
		String[] strarr = text.split(" ");
		
		//c) Create a empty Set 
		Set<String> strset = new LinkedHashSet<String>();
		
		//d) Iterate the String array [and] d.1) add each word into Set
		for(String i : strarr) {			
			strset.add(i);
		}
		System.out.println("The String after removing duplicate words is: ");	
		
		//e) Print the Set values which is having unique words
		for(String wrds : strset) {
			System.out.print(wrds + " ");
		}
	}
}
