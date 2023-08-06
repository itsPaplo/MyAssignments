package week3.day2.assignments;

public class ReverseEvenWords {

	public static void main(String[] args) {

		String test = "I am a software tester"; 
		String[] trmdwrd = test.split(" ");
		String rvrsd = "";
		for(int i=0;i<trmdwrd.length;i++) {
			if(i%2==1) {				
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

		System.out.println("The words in the Even position reversed will be : " + rvrsd);
	}
}
