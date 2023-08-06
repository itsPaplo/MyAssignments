package week3.day2.assignments;

import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,8,10};
		Set<Integer> arrset = new TreeSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			arrset.add(arr[i]);
		}
		System.out.print("Missing element in the array is: ");
		int indx = 0;
		for(int i : arrset) {
			if((indx+1)!=i) {
				System.out.print(indx + 1 + " ");
				indx++;
			}
			indx++;
		}
	}
}
