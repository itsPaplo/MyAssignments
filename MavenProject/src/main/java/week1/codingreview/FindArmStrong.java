package week1.codingreview;

public class FindArmStrong {
	
	public static boolean isArmStrong(long num) {
		long temp, reminder, prod=1, sum = 0;
		int digit=0, i=0, j=0;
		temp=num;
		for(i=0;temp>0;i++) {
			temp = temp/10;
			digit++;			
		}
		//System.out.println("Digits: " + digit);
		temp=num;
		for(i=0;temp>0;i++) {
			reminder=temp%10;
			prod=1;
			for(j=0;j<digit;j++) {
				prod=prod*reminder;				
				//System.out.println("reminder: " + reminder +" " + "Prod: " + prod);
			}
			sum=sum+prod;	
			//System.out.println("sum:" + sum + " " + "prod: " + prod );
			temp=temp/10;
		}
		if(sum == num) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		long number = 4679307774l;
		boolean res = isArmStrong(number);
		if(res == true) {
			System.out.println("The Given number " + number + " is an Armstrong number");
		}
		else {
			System.out.println("The Given number " + number + " is not an Armstrong number");
		}
	}

}
