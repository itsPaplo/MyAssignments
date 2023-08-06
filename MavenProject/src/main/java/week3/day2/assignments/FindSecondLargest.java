package week3.day2.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {
		
		/*
		 * Pseudo Code: 
		 * a) Create a empty Set Using TreeSet
		 * b) Declare for loop iterator from 0 to data.length and add into Set 
		 * c) converted Set into List
		 * d) Print the second last element from List
		 * 
		 * 
		 */

		int[] data = {3,2,11,4,6,7,2,3,3,6,7};
		
		//a) Create a empty Set Using TreeSet
		Set<Integer> numset = new TreeSet<Integer>();
		List<Integer> numlist = new ArrayList<Integer>();
		
		//b) Declare for loop iterator from 0 to data.length and add into Set
		for(int i=0;i<data.length;i++) {
			numset.add(data[i]);
		}
		
		//c) converted Set into List
		numlist.addAll(numset);

		//d) Print the second last element from List
		System.out.println("The second Largest element in the given integer array is: " + numlist.get(numlist.size()-2));				
	}
}
