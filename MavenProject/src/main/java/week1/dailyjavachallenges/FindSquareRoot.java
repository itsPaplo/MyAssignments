package week1.dailyjavachallenges;

public class FindSquareRoot {
	
	public static double squarert(double n) {
		double sqrt = n/2;
		double temp;
		for(int i=0;i<n;i++) {
			temp = sqrt;
			sqrt = (temp + (n/temp))/2;
			if(temp-sqrt == 0) {
				return sqrt;
			}
		}
		
		return n;
		
	}
	
	public static void main(String[] args) {
		double number = 8;
		int result = (int) squarert(number);
		System.out.println("The square root of given number " +(int) number +" is: " + result );
	
	}

}
