package week2.dailyjavachallenges;

import java.util.ArrayList;
import java.util.List;

public class ArrayOccurences {

	public static boolean findOccurences(int[] array) {

		List<Integer> dsnt = new ArrayList<Integer>();
		List<Integer> freq = new ArrayList<Integer>();
		int len = array.length;
		int count;
		int flag=0;
		for(int i=0;i<len;i++) {
			flag=0;
			for(int j=0;j<i;j++) {
				if(array[i] == array[j]) {
					flag++;
				}				
			}
			if(flag==0) {
				dsnt.add(array[i]);
			}
		}

		for(int i=0;i<dsnt.size();i++) {
			count=0;
			for(int j=0;j<len;j++) {
				if(dsnt.get(i)==array[j]) {
					count++;
				}
			}
			freq.add(count);
		}		

		for(int i=0;i<freq.size();i++) {
			flag=0;
			for(int j=0;j<freq.size();j++) {
				if(freq.get(i)==freq.get(j)) {
					flag++;
				}				
			}
			if(flag>1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,2,1,1,3};
		boolean res = findOccurences(arr);
		if(res == true) {
			System.out.println("The Number of occurrences of each value in the array is unique");
		}
		else {
			System.out.println("The Number of occurrences of each value in the array is not unique");
		}

	}

}
