package week3.day1.assignments.assignment5;

public class Automation extends MultipleLangauge implements Language,TestTool{

	public void Selenium() {
		
		System.out.println("Method 02: called from Interface " + '"' + "TestTool" + '"');
		
	}

	public void Java() {
		
		System.out.println("Method 01: called from Interface" + '"' + "Language" + '"');
		
	}

	@Override
	public void ruby() {
		
		System.out.println("Method 04: abstract method called from Abstract class" + '"' + "MultipleLanguages" + '"');
		
	}
	
	public static void main(String[] args) {
		Automation auto = new Automation();
		auto.Java();
		auto.Selenium();
		auto.python();
		auto.ruby();
	}

}
