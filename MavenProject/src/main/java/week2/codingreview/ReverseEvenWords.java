package week2.codingreview;

public class ReverseEvenWords {
	
	public static String reverseEvenWords(String str) {
		
		String[] trmdwrd = str.split(" ");
		String rvrsd = "";
		for(int i=0;i<trmdwrd.length;i++) {
			if(i%2==1) {
				//String rwd = new StringBuilder(trmdwrd[i]).reverse().toString();
				String rwchr="";
				char[] c = trmdwrd[i].toCharArray();
				
				for(int j=c.length-1;j>=0;j--) {
					char[] crw = new char[c.length];
					crw[j] = c[j];
					rwchr = rwchr + crw[j];
				}
				
				rvrsd = rvrsd + rwchr + " ";
			}
			else {
				rvrsd = rvrsd + trmdwrd[i] + " ";
			}
		}
		
		return rvrsd;	
	}
	
	public static void main(String[] args) {
		
		String wrd = "I am a Software Tester";
		String rvrsdwrd = reverseEvenWords(wrd);
		System.out.println("The words in the Even position reversed will be : " + rvrsdwrd);		
	}

}
