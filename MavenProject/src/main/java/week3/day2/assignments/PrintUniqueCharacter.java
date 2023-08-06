package week3.day2.assignments;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PrintUniqueCharacter {

	public static void main(String[] args) {		
		/*
		 * Psuedocode
		 * 
		 * a) Convert String to Character array
		 * b) Create a new Set -> HashSet
		 * c) Add each character to the Set and if it is already there, remove it
		 * d) Finally, print the set
		 * 
		 */
		
		String word = "Philip";
		
		//a) Convert String to Character array
		char[] carr = word.toLowerCase().toCharArray();	
		
		//b) Create a new Set -> HashSet
		Set<Character> cset = new HashSet<Character>();
		Set<Character> cdupset = new TreeSet<Character>();
		
		//c) Add each character to the Set and if it is already there, remove it
		for(int i=0;i<carr.length;i++) {
			if(!(cset.add(carr[i]))) {
				cdupset.add(carr[i]);
			}			
		}		
		cset.removeAll(cdupset);
		
		
		System.out.print("Unique characters from the given string " + '"' + word + '"' + " are : ");
		//d) Finally, print the set
		for(char c : cset) {
			System.out.print(c + " ");
		}
	}
}
