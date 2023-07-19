package chapter25;

public class RunEndlessThreads {
    public static void main(String[] args) {
        RunEndlessThreads sample = new RunEndlessThreads();
        sample.endless();
    }

    private void endless() {
        EndlessThread thread = new EndlessThread();
        thread.start();
    }
}
