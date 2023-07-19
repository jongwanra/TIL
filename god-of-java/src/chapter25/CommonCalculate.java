package chapter25;

public class CommonCalculate {
    private int amount;

    public CommonCalculate() {
        amount = 0;
    }

    public void plus(int value){
        synchronized (this) {
            this.amount += value;
        }

    }

    public synchronized void minus(int value) {
        amount -= value;
    }

    public int getAmount() {
        return amount;
    }
}
