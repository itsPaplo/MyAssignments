package week3.day1.assignments.assignment1;

public class Desktop extends Computer {
	
	public void desktopSize() {
		System.out.println("Method 02: called from inheriting Class Desktop");
	}
	
	public static void main(String[] args) {
		Desktop dp = new Desktop();
		dp.computerModel();
		dp.desktopSize();
	}
}
