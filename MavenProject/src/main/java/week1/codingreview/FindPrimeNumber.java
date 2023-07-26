package week1.codingreview;

public class FindPrimeNumber {
	public static void main(String[] args) {
		int number = 43, flag=0;	
		if(number == 0 || number == 1){
				System.out.println("The Given number: " + number + " is not a prime number");	
			}
		
		for(int i=2; i<=number; i++) {
			if(number!=i && number%i==0) {
				flag++;
			}
			else if (number == i && number%i==0 && flag == 0){
				System.out.println("The Given number: " + number + " is a prime number");
			}
		
		}
		if (flag!=0) {
			System.out.println("The Given number: " + number + " is not a prime number");		
		}
	}

}
