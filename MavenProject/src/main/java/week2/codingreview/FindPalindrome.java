package week2.codingreview;

public class FindPalindrome {

	public static boolean checkPalindrome(String str) {
		char[] carr = str.toCharArray();
		int len = carr.length;
		String rvrsd = "";
		for(int i=len-1;i>=0;i--) {
			rvrsd = rvrsd +	carr[i];
		}

		if(rvrsd.contentEquals(str)) {
			return true;
		}
		else {
			return false;
		}	
	}

	public static void main(String[] args) {
		String word = "POSTMALONE";
		boolean result = checkPalindrome(word);
		if(result == true) {
			System.out.println("The given string: "+ '"'+ word + '"'+ " is a Palindrome" );
		}
		else {
			System.out.println("The given string: "+ '"' + word + '"' +" is not a Palindrome" );				
		}
	}

}
