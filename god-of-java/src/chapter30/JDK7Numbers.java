package chapter30;

public class JDK7Numbers {
    public static void main(String[] args) {
        JDK7Numbers numbers = new JDK7Numbers();
        numbers.jdk6();
        numbers.jdk7();
        numbers.jdk7Underscore();
    }

    private void jdk7Underscore() {
        int binaryNumber = 0b0100_0101_0010;
        int million = 1_000_000;
        System.out.println("binaryNumber = " + binaryNumber);
        System.out.println("million = " + million);
    }

    private void jdk6() {
        int decimalNumber = 1106;
        int octalNumber = 02122;
        int hexadecimalNumber = 0x452;

        System.out.println("decimalNumber = " + decimalNumber);
        System.out.println("octalNumber = " + octalNumber);
        System.out.println("hexadecimalNumber = " + hexadecimalNumber);
    }

    private void jdk7() {
        int binaryNumber = 0b10001010010;
        System.out.println("binaryNumber = " + binaryNumber);
    }
}
