package week1.day2.classroom;

public class Mobile {
	
	public void sendSms() {
		System.out.println("From oppo"); 	
	 
	}
	
	public long makeCall(long phno) {
		return phno;
	}
	
	public static void main(String[] args) {
		
		Mobile mob1 = new Mobile();
		mob1.sendSms();
		long callingNumber =mob1.makeCall(8123873455l);
		System.out.println(callingNumber);
		
	}

}
