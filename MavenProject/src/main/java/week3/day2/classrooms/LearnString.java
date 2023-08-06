package week3.day2.classrooms;

public class LearnString {

	public static void main(String[] args) {
		String name = "Philip";
		char[] carr = name.toCharArray();
		System.out.print("Reverse of the name is: ");
		for(int i=carr.length-1; i>=0;i--) {		
			System.out.print(carr[i]);
		}			
	}


}
