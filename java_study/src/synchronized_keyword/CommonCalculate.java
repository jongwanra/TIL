package synchronized_keyword;

public class CommonCalculate {
	Object lock = new Object();
	private int amount;
	
	public CommonCalculate() {
		amount = 0;
	}
	
	public void plus(int value) {
		synchronized (lock) {
			System.out.println(
				"currentThread: " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
			amount += value;
		}
	}
	
	public synchronized void minus(int value) {
		amount -= value;
	}
	
	public int getAmount() {
		return amount;
	}
}
