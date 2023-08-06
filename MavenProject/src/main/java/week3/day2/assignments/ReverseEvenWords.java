package week3.day2.assignments;

public class ReverseEvenWords {

	public static void main(String[] args) {

		String test = "I am a software tester"; 
		String[] testarr = test.split(" ");
		String teststr = "";
		for(int i=0;i<testarr.length;i++) {
			if(i%2==1) {				
				String testchr="";
				char[] c = testarr[i].toCharArray();

				for(int j=c.length-1;j>=0;j--) {
					char[] crw = new char[c.length];
					crw[j] = c[j];
					testchr = testchr + crw[j];
				}

				teststr = teststr + testchr + " ";
			}
			else {
				teststr = teststr + testarr[i] + " ";
			}
		}

		System.out.println("The words in the Even position reversed will be : " + teststr);
	}
}
