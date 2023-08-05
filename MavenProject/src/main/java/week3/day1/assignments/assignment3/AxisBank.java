package week3.day1.assignments.assignment3;

public class AxisBank extends BankInfo {

	public void deposit() {
		super.deposit();
		System.out.println("Overriden Method 03: Deposit called from BankInfo class but overriden in Axisbank class");
	}
	
	public static void main(String[] args) {
		AxisBank axsbnk = new AxisBank();
		axsbnk.saving();
		axsbnk.fixed();
		axsbnk.deposit();
	}
}
