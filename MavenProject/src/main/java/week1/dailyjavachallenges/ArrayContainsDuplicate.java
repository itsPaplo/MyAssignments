package week1.dailyjavachallenges;

public class ArrayContainsDuplicate {

	public static boolean hasDuplicates(int[] array1) {
		int count=0;
		for(int i=0;i<array1.length;i++) {
			count = 0;
			for(int j =0;j<array1.length;j++) {
				if(array1[i]==array1[j]) {
					count++;
				}					
			}
			if(count==0) {
				return false;
			}
		}
		if(count>=2) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = {1,1,1,3,3,4,3,2,4,2};
		boolean res= hasDuplicates(arr);
		if(res==true) {
			System.out.println("The Array doesnt have distinct elements: " + res);
		}
		else {
			System.out.println("The Array doesnt have distinct elements: " + res);
		}
		
		
	}	
	
}
