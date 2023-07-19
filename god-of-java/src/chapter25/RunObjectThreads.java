package chapter25;

public class RunObjectThreads {
    public static void main(String[] args) {
        RunObjectThreads sample = new RunObjectThreads();
        sample.checkThreadState3();
    }

    private void checkThreadState2() {
        Object monitor = new Object();
        StateThread thread = new StateThread(monitor);

        try{
            System.out.println("thread state=" + thread.getState());
            thread.start();
            System.out.println("thread State(after start)=" + thread.getState());

            Thread.sleep(100);
            System.out.println("thread State(after 0.1 sec)=" + thread.getState());

            synchronized (monitor) {
                monitor.notify();
            }
            Thread.sleep(100);
            System.out.println("thread State(after notify)=" + thread.getState());

            thread.join();
            System.out.println("thread State(after join)=" + thread.getState());
        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private void checkThreadState3() {
        Object monitor = new Object();
        StateThread thread = new StateThread(monitor);
        StateThread thread2 = new StateThread(monitor);

        try{
            System.out.println("thread state=" + thread.getState());
            thread.start();
            thread2.start();

            System.out.println("thread State(after start)=" + thread.getState());

            Thread.sleep(100);
            System.out.println("thread State(after 0.1 sec)=" + thread.getState());

            synchronized (monitor) {
                monitor.notify();
            }
            Thread.sleep(100);
            System.out.println("thread State(after notify)=" + thread.getState());

            thread.join();
            System.out.println("thread State(after join)=" + thread.getState());

            thread2.join();
            System.out.println("thread2 State(after join)=" + thread2.getState());
        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
