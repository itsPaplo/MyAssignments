package week2.codingreview;

public class CountCharacters {
	
	public static int charCount(String str) {
		int count =0;
		char c = 'e';
		char[] carr = str.toCharArray();
		for(int i=0;i<carr.length;i++) {
			if(carr[i] == c) {
				count++;
			}
		}		
		
		return count;
		
	}
	
	public static void main(String[] args) {
		
		String str = "Welcome to Chennai";
		
		System.out.println("The count of char: " + "'e'" + " in the string: " + str + " is: " + charCount(str)); 
		
		
	}

}
