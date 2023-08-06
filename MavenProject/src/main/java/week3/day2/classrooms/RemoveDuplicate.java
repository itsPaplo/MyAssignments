package week3.day2.classrooms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicate {

	public static void main(String[] args) {
		String str = "google";
		char[] carr = str.toCharArray();
		Set<Character> carrset = new LinkedHashSet<Character>();
		List<Character> c = new ArrayList<Character>();

		for(int i=0;i<carr.length;i++) {
			carrset.add(carr[i]);
		}
		c.addAll(carrset);

		System.out.println("String after duplicate characters removed is: ");
		for (int i=0;i<c.size();i++) {
			System.out.print("'" + c.get(i) + "'");
		}
	}

}


