package week1.codingreview;

public class ReverseString {
	public static String reverseString(String input) {
		String reversed = "";
		for(int i=0;i<input.length();i++) {
			reversed=input.charAt(i) + reversed;
		}
		return reversed;
	}

	
	public static void main(String[] args) {
		String str= "TestLeaf";
		String result = reverseString(str);
		if(result.length()==0) {
			System.out.println("Invalid Input");
		}
		else {
		System.out.println("The Reverse of the given string " + str + " is: " + result);
		}
			
	}

}
