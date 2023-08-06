package week3.day2.assignments;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		/*
		 Pseudo Code

		 * Declare String Input as Follow

		 * String test = "changeme";

		 * a) Convert the String to character array

		 * b) Traverse through each character (using loop)

		 * c)find the odd index within the loop (use mod operator)

		 * d)within the loop, change the character to uppercase, if the index is odd else don't change

		 */

		String test ="changeme";

		//a) Convert the String to character array
		char[] carr = test.toCharArray();		

		//b) Traverse through each character (using loop)
		int indx=0;
		for(int i=0;i<carr.length;i++) {
			indx=i+1;
			//c)find the odd index within the loop
			if(indx%2==1) {
				//d)within the loop, change the character to uppercase, if the index is odd else don't change
				carr[i] = Character.toUpperCase(carr[i]);					
			}				

		}

		System.out.print("The Characters at odd index positions of the String: "+ test + " are converted to upper case as : ");
		for (char c : carr) {
			System.out.print(c);
		}

	}

}
