package chapter15;

public class StringMethod {
    public static void main(String[] args) {
        StringMethod sample = new StringMethod();
        sample.checkSubString();
    }

    private void checkSubString() {
        String text = "hello world";
        String helloText = text.substring(0, 5);
        String worldText = text.substring(6);
        System.out.println("text = " + text);
        System.out.println("helloText = " + helloText);
        System.out.println("worldText = " + worldText);

    }
}
