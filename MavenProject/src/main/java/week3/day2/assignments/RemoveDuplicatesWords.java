package week3.day2.assignments;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesWords {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";

		String[] strarr = text.split(" ");
		Set<String> strset = new LinkedHashSet<String>();
		for(String i : strarr) {			
			strset.add(i);
		}
		System.out.println("The String after removing duplicate words is: ");		
		for(String wrds : strset) {
			System.out.print(wrds + " ");
		}
	}
}
