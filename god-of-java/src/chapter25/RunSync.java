package chapter25;

public class RunSync {
    public static void main(String[] args) {
        RunSync runSync = new RunSync();
        runSync.runCommonCalculate();
    }

    private void runCommonCalculate() {
        CommonCalculate calc = new CommonCalculate();
        ModifyAmountThread thread1 = new ModifyAmountThread(calc, true);
        ModifyAmountThread thread2 = new ModifyAmountThread(calc, true);

        Thread t = Thread.currentThread();

        // Getting name of Main thread
        System.out.println("Current thread: " + t.getName());


        System.out.println("thread1 = " + thread1.getName());
        System.out.println("thread2 = " + thread2.getName());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            System.out.println("thread1.join end----");
            thread2.join();
            System.out.println("thread2.join end----");
            System.out.println("Final value is" + calc.getAmount());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
