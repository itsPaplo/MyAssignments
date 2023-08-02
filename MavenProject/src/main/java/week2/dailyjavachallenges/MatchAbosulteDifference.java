package week2.dailyjavachallenges;

public class MatchAbosulteDifference {

	public static boolean isabsdiffmatch(int[] array, int chk) {
		int absdiff, count;
		for(int i=0;i<array.length;i++) {
			count=0;
			for(int j =0;j<array.length;j++) {
				
				if((array[i]==array[j]) && (i!=j)){
					absdiff=0;
					if(i<j) {
						absdiff = j-i;
						if(absdiff<=chk) {
							count++;
						}						
					}
					if(j<i) {
						absdiff = i-j;
						if(absdiff<=chk) {
							count++;
						}	
					}
				}
			}
			if(count>=1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,1};
		int k =3;
		boolean result = isabsdiffmatch(arr, k);
		if(result == true) {
			System.out.println("There are two distinct indices in the given array: " + result);
		}
		else {
			System.out.println("There are two distinct indices in the given array: " + result);	
		}


	}

}
