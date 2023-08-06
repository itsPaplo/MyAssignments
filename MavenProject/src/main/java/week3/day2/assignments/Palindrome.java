package week3.day2.assignments;

public class Palindrome {
	public static void main(String[] args) {
		/*
		 * Pseudo Code
		
		 * a) Declare A String value as"madam"
		 
		 * b) Declare another String rev value as ""
		 * c) Iterate over the String in reverse order
		 * d) Add the char into rev
		 * e) Compare the original String with the reversed String, if it is same then print palinDrome 
		 
		 * Hint: Use .equals or .equalsIgnoreCase when you compare a String 
		 */
		
		//a) Declare A String value as"madam"
		String value = "madam";
		
		//b) Declare another String rev value as ""
		String rev ="";
		
		//c) Iterate over the String in reverse order
		int len = value.length();
		
		for(int i = len-1;i>=0;i--) {
			//d) Add the char into rev
			rev = rev + value.charAt(i);
		}
		
		//e) Compare the original String with the reversed String, if it is same then print palinDrome 
		if(rev.equalsIgnoreCase(value)) {
			System.out.println("The Given string " +'"' + value + '"'  +  " is a Palindrome");
		}
		else {
			System.out.println("The Given string " +'"' + value + '"'  +  " is not a Palindrome");
		}	
		
	}

}
