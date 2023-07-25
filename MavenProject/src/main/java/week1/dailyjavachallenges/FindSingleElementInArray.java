package week1.dailyjavachallenges;

public class FindSingleElementInArray {
	
	//Java Challenge [2/20]
	//To find Unique element in a non-empty integer array

	public static void main(String[] args) {
		int[] array1 = {4,1,2,1,2};
		int count=0;
		int len = array1.length;
		for (int i=0;i<len;i++) {
			count=0;
			for(int j=0;j<len;j++) {
				if((i!=j) && array1[i]==array1[j]) {
					count++;
				}
			}
			if(count==0) {
				System.out.println(array1[i]);
			}
		}
	}
	
}
