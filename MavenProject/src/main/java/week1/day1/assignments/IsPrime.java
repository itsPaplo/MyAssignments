package week1.day1.assignments;

public class IsPrime {
	
	public static void main(String[] args) {
		int number = 42, flag=0;	
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
