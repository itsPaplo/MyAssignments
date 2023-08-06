package week3.day2.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {

		int[] data = {3,2,11,4,6,7,2,3,3,6,7};
		Set<Integer> numset = new TreeSet<Integer>();
		List<Integer> numlist = new ArrayList<Integer>();
		for(int i=0;i<data.length;i++) {
			numset.add(data[i]);
		}
		numlist.addAll(numset);

		System.out.println("The second Largest element in the given integer array is: " + numlist.get(numlist.size()-2));				
	}
}
