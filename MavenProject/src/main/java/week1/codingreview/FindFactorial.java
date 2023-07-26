package week1.codingreview;

public class FindFactorial {

	public static int getFactorial(int num) {
		int fact=1;
		for(int i=1;i<=num;i++) {
			fact=fact*i;
		}		
		return fact;
	}
	public static void main(String[] args) {
		int number = 8;
		int res = getFactorial(number);
		System.out.println("The Factorial of "+ number + "! is: " + res);
	}
}
