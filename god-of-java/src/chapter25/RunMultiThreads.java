package chapter25;

public class RunMultiThreads {
    public static void main(String[] args) {
        RunMultiThreads sample = new RunMultiThreads();
        sample.runMultiThread();
    }

    private void runMultiThread() {
        RunnableSample[] runnable = new RunnableSample[5];
        ThreadSample[] thread = new ThreadSample[5];

        for(int loop = 0; loop < 5; loop++) {
            runnable[loop] = new RunnableSample();
            thread[loop] = new ThreadSample();

            new Thread(runnable[loop]).start();
            thread[loop].start();
        }
        System.out.println("RunMultiThread.runMultiThread() method is ended");


    }
}
