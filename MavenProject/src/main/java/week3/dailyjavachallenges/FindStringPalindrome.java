package week3.dailyjavachallenges;

public class FindStringPalindrome {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		String ns = s.replaceAll("[^a-zA-Z0-9]","");
		char[] carr = ns.toCharArray();
		String rev ="";
		for(int i=carr.length-1;i>=0;i--) {
			rev = rev+carr[i];
		}
		if(rev.equalsIgnoreCase(ns)) {
			System.out.println("The Given string " +'"' + s + '"'  +  " is a Palindrome");
		}
		else {
			System.out.println("The Given string " +'"' + s + '"'  +  " is not a Palindrome");
		}		
	}

}
