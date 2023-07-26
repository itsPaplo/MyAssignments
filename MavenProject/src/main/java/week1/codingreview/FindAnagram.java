package week1.codingreview;

public class FindAnagram {

	public static boolean isAnagram(String input1, String input2) {
		int count=0;
		System.out.println(input1 + " " + input2);
		if(input1.length()!=input2.length()) {
			return false;
		}
		else {
			for (int i=0;i<input1.length();i++) {
				for(int j=0;j<input2.length();j++) {
					if(input1.charAt(i)==input2.charAt(j)) {
						count++;
					}
				}
			}				
			if(count>=input1.length()) {
				return true;
			}
			else {
				return false;
			}
		}
		
		
	}
	public static void main(String[] args) {
		String str1 = "amma";
		String str2 = "mama";
		String s1 = str1.toLowerCase();
		String s2 = str2.toLowerCase();
		boolean res = isAnagram(s1, s2);
		if(res == true) {
			System.out.println("The Given words " + s1 + " and " + s2 + " are Anagrams");
		}
		else {
			System.out.println("The Given words " + str1 + " and " + str2 + " are not Anagrams");
		}
	
 
	}
	
}
