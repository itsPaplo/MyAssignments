package week3.day1.classroom;

public class Calculator {
	
	//Addition
	public int adds(int a, int b) {		
		return a+b;
	}
	
	public int adds(int a, int b, int c) {		
		return a+b+c;
	}	
	
	//Multiplication	
	public double multiply(double a, double b) {		
		return a*b;
	}
	
	public float multiply(float a, float b) {		
		return a*b;
	}	
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		System.out.println("Calling Method 01: " + " Integer sum is: " + calc.adds(2, 8));
		System.out.println("Calling Method 02: " + " Three integer sum is: " + calc.adds(2, 6, 4));
		System.out.println("Calling Method 03: " + " Double Multiplication is: " + calc.multiply(5.81216732,7.8368));
		System.out.println("Calling Method 04: " + " Float Multiplication is: " + calc.multiply(2.5f, 4.5f));
	}

}
