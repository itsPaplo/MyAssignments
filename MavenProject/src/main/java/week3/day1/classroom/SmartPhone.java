package week3.day1.classroom;

public class SmartPhone extends AndroidPhone{

	public void takeVideo() {
		super.takeVideo();
		System.out.println("Overriden Method 1: called from " + '"'+ "SmartPhone" + '"' +" class");
	}
	
	public static void main(String[] args) {
		SmartPhone smsng = new SmartPhone();
		smsng.takeVideo();
	}
	
}
