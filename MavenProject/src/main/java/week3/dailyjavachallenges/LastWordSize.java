package week3.dailyjavachallenges;

public class LastWordSize {

	public static void main(String[] args) {
		String s = "   fly me   to   the moon  ";
		String[] sarr = s.split("\\s+");
		int len = sarr.length;
		char[] c = sarr[len-1].toCharArray();
		System.out.print("The size of the last word in the given string: " + '"' + s + '"' + " is: " );		
		System.out.print(c.length);
	}
}
