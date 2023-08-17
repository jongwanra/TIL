package synchronized_keyword;

public class RunSync {
	public static void main(String[] args) {
		RunSync runSync = new RunSync();
		runSync.runCommonCalculate();
	}
	
	private void runCommonCalculate() {
		CommonCalculate calc = new CommonCalculate();
		ModifyAmountThread thread1 = new ModifyAmountThread(calc, true);
		ModifyAmountThread thread2 = new ModifyAmountThread(calc, true);
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
			
			System.out.println("calc = " + calc.getAmount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
