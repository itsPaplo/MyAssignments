package week3.day2.assignments;

import java.util.Arrays;

public class SortingUsingCollection {

	public static void main(String[] args) {

		// Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)		
		String[] companies = {"HCL", "Wipro", "Aspire Systems", "CTS"};

		// get the length of the array
		int len = companies.length;

		// sort the array
		Arrays.sort(companies);

		// Iterate it in the reverse order
		System.out.print("The reverse order of the elements in provided String array is: ");
		for(int i=len-1; i>=0;i--) {		
			// print the array
			System.out.print('"' + companies[i] + '"' + " ");

		}
		// Required Output: Wipro, HCL , CTS, Aspire Systems

	}
}
