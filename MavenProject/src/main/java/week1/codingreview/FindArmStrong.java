package week1.codingreview;

public class FindArmStrong {
	
	public static boolean isArmStrong(long num) {
		long temp, sum, rem1, rem2;
		temp = num;
		for(int i=0; i<num;i++) {
			rem1 = temp%10;
			sum = temp/10;
			if (sum <= 9) {
				sum = sum * sum * sum +  rem1 * rem1 * rem1;
			}
			else {
				temp = sum;				
				rem2 = temp%10;
				sum = temp/10;
				sum = sum * sum * sum + rem2 * rem2 * rem2 + rem1 * rem1 * rem1;				
			}
			
			if(sum == num) { 
				return true;
			} 
			else {
				temp = sum; 				
			}
		}
		return false;

	}
	
	public static void main(String[] args) {
		long number = 153;
		boolean res = isArmStrong(number);
		if(res==true) {
			System.out.println("The Given number " + number + " is an Armstrong number ");
		}
		else {
			System.out.println("The Given number " + number + " is not an Armstrong number ");
		}
	}

}
