package chapter25;

public class RunSupportThreads {
    public static void main(String[] args) {
        RunSupportThreads sample = new RunSupportThreads();
        sample.checkJoin();
    }

    private void checkJoin() {
        SleepThread thread = new SleepThread(2000);

        try{
            Thread.dumpStack();
            System.out.println("thread State=" + thread.getState());
            thread.start();

            System.out.println("thread State(after start)=" + thread.getState());
            thread.join(500);
            thread.interrupt();
            System.out.println("thread State(after join)=" + thread.getState());

        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private void checkThreadState1() {
        SleepThread thread = new SleepThread(2000);

        try{
            System.out.println("thread State=" + thread.getState());
            thread.start();

            System.out.println("thread State(after start)=" + thread.getState());


            Thread.sleep(1000);
            System.out.println("thread State(after 1 sec)=" + thread.getState());

            thread.join();
            System.out.println("thread State(after join)=" + thread.getState());
            thread.interrupt();
            System.out.println("thread State(after join)=" + thread.getState());

        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
