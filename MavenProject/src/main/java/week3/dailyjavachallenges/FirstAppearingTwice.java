package week3.dailyjavachallenges;

public class FirstAppearingTwice {
	
	public static void main(String[] args) {
		String s = "abcdd";
		char[] carr = s.toCharArray();
		int i=0,j=1;
		System.out.print("The first letter to appear twice in the given string: " + '"' + s + '"' + " is: ");
		for(char c : carr) {
			if(carr[i]==carr[j]) {
				System.out.print(c);
				break;
			}
			i++; j++;
		}
	}

}
