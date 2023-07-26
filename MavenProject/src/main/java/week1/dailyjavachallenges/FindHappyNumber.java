package week1.dailyjavachallenges;

public class FindHappyNumber {
	
	public static void main(String[] args) {
		int number = 19;
		int temp, sum, rem1, rem2;
		temp = number;
		for(int i=0; i<temp;i++) {
			rem1 = temp%10;
			sum = temp/10;
			if (sum <= 9) {
				sum = sum * sum +  rem1*rem1;
			}
			else {
				temp = sum;				
				rem2 = temp%10;
				sum = temp/10;
				sum = sum * sum + rem2 * rem2 + rem1 * rem1;				
			}
			
			if(sum == 1) { 
				System.out.println("The given number "+ number +" is a Happy number");
				break;
			} 
			else if(sum == 4) {
				System.out.println("The given number "+ number + " is not a Happy number");
				break;
			} 
			else {
				temp = sum; 
			}
		}

	}

}
