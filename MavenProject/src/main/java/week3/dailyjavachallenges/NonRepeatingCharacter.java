package week3.dailyjavachallenges;

import java.util.LinkedHashSet;
import java.util.Set;


public class NonRepeatingCharacter {

	public static void main(String[] args) {
		String s = "loveleetcode";
		char[] carr = s.toLowerCase().toCharArray();
		Set<Character> cset = new LinkedHashSet<Character>();
		Set<Character> dupcset = new LinkedHashSet<Character>();
		for(int i=0;i<carr.length;i++) {
			if(!(cset.add(carr[i]))) {
				dupcset.add(carr[i]);
			}
		}

		cset.removeAll(dupcset);
		if(cset.size()==0) {
			System.out.println("-1");
		}
		if(cset.size()!=0) {
			char[] carr2 = new char[cset.size()];
			int ind=0;
			for(char cs : cset) {
				carr2[ind] = cs;
				ind++;
			}

			System.out.print("The index of the first non-repeating character in the given String " + '"'+  s + '"' + " is: ");
			for(int j=0;j<carr.length;j++) {
				for(int k=0;k<carr2.length;k++) {
					if(carr[j]==carr2[k]) {		
						System.out.println(j);
					}
					break;				
				}
			}
		}

	}

}
