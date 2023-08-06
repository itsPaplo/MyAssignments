package week3.day2.assignments;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		String word = "Philip";
		char[] carr = word.toLowerCase().toCharArray();		
		Set<Character> cset = new HashSet<Character>();
		Set<Character> cdupset = new TreeSet<Character>();
		for(int i=0;i<carr.length;i++) {
			if(!(cset.add(carr[i]))) {
				cdupset.add(carr[i]);
			}			
		}		
		cset.removeAll(cdupset);
		System.out.print("Unique characters from the given string " + '"' + word + '"' + " are : ");
		for(char c : cset) {
			System.out.print(c + " ");
		}
	}
}
