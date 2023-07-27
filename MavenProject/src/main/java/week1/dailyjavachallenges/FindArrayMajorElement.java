package week1.dailyjavachallenges;

public class FindArrayMajorElement {

	public static void main(String[] args) {
		int[] arr= {2,2,1,1,1,2,2};
		int len = arr.length;
		int freq=0, count=0, index=0;
		for(int i=0;i<len;i++) {
			freq=0;
			for(int j=0;j<len;j++) {
				if(arr[i]==arr[j]) {
					freq++;
				}
			}
			if(freq>count) {
				count=freq;
				index=i;
			}			
		}
		if(count>len/2) {
			System.out.println("The Major element in the given array is: " + arr[index]);
		}
		else {
			System.out.println("There are no Major element in the given array ");
		}
		
		
	}
	
}
