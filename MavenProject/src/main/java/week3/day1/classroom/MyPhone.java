package week3.day1.classroom;

public class MyPhone {
	
	public static void main(String[] args) {
		iPhone ipn = new iPhone();
		ipn.startApp();
		ipn.increaseVolume();
		ipn.makeCall();
		ipn.sendSMS();
		ipn.shutDown();
		
		//cant access iPad's methods with iphone's object
		//ipn.watchMovie();
	}

}
