package chapter20;

public class JavaLangSystem {
    public static void main(String[] args) {
        JavaLangSystem sample = new JavaLangSystem();
        sample.numberMinMaxElapsedCheck();
    }

    protected void systemPropertiesCheck() {
        System.out.println("java.version=" + System.getProperty("java.version"));
        System.out.println("JAVA_HOME="+System.getenv("JAVA_HOME"));
    }

    private void numberMinMaxElapsedCheck() {
        JavaLangNumber numberSample = new JavaLangNumber();
        long startTime = System.currentTimeMillis();
        long startNanoTime = System.nanoTime();

        numberSample.numberTypeCheck();

        System.out.println("Milli second=" + (System.currentTimeMillis() - startTime));
        System.out.println("Nano second=" + (System.nanoTime() - startNanoTime) / 1_000_000);
    }
}
