package week3.day2.assignments;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicates {

	public static void main(String[] args) {
		//Declare a String as "PayPal India"
		String word = "PayPal India";
		//word.replace(" ", "");

		//Convert it into a character array
		char[] carr = word.toLowerCase().toCharArray();

		//Declare a Set as charSet for Character
		Set<Character> charset = new TreeSet<Character>();

		//Declare a Set as dupCharSet for duplicate Character
		Set<Character> dupCharSet = new TreeSet<Character>();

		//Iterate character array and add it into charSet
		for(int i=0;i<carr.length;i++) {
			//if the character is already in the charSet then, add it to the dupCharSet
			if(!(charset.add(carr[i]))) {
				dupCharSet.add(carr[i]);
			}
		}		

		//Check the dupCharSet elements and remove those in the charSet
		charset.removeAll(dupCharSet);

		System.out.print("The Duplicate characters in the given string " + '"' + word + '"' + " : ");
		//Iterate using charSet
		for(char c : charset) {
			//Check the iterator variable isn't equals to an empty space
			if(c!=' ') {
				//print it
				System.out.print(c + " ");
			}

		}		
	}
}
