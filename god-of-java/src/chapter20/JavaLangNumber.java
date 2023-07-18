package chapter20;

import java.util.Arrays;

public class JavaLangNumber {
    public static void main(String[] args) {
        JavaLangNumber sample = new JavaLangNumber();
        sample.numberTypeCheck();
    }

    private void numberTypeCheck() {
        String value1 = "3";
        String value2 = "5";
        byte byte1 = Byte.parseByte(value1);

        System.out.println("byte1 = " + byte1);
        byte byte2 = Byte.parseByte(value2);
        System.out.println("byte2 = " + byte2);

        System.out.println(byte1 + byte2);

        Integer refInt1 = Integer.valueOf(value1);
        Integer refInt2 = Integer.valueOf(value2);
        System.out.println(refInt1 + refInt2 + "7");


    }
}
