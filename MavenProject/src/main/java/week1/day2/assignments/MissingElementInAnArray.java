package week1.day2.assignments;

import java.util.Arrays;

public class MissingElementInAnArray {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,8,10};
		int len = arr.length;
		/* without using .sort()
		 * for(int i=0;i<len;i++) { for(int j=i+1;j<len;j++) { int temp=0;
		 * if(arr[i]>arr[j]) { temp=arr[i]; arr[i]=arr[j]; arr[j]=temp; } } }
		 */

		Arrays.sort(arr);
		for(int i=0;i<len;i++){
			if((i+1)!=arr[i]){
				System.out.println(i+1);
				break;
			}
		}
	
	}
}
