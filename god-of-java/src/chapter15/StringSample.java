package chapter15;

import java.util.Arrays;

public class StringSample {
    public static void main(String[] args) {
        StringSample sample = new StringSample();
        int a = 10;
        int a1 = 10;
        int a2 = 10;
        int a3 = 10;
        float b = 20.0f;
        long c = 0L;

        sample.convert();
        sample.convertUTF16();
        sample.convertEUCKR();
    }

    public void printByteArray(byte[] array) {
        for(byte data: array) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    private void convertEUCKR() {
        try{
            System.out.println("EUC-KR");
            String korean = "나종완";

            byte[] array1 = korean.getBytes("EUC-KR");
            printByteArray(array1);

            String korean2 = new String(array1, "EUC-KR");
            System.out.println(korean2);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void convert() {
        try{
            System.out.println("UTF-8");
            String korean = "나종완";

            byte[] array1 = korean.getBytes();
            printByteArray(array1);

            String korean2 = new String(array1);
            System.out.println(korean2);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void convertUTF16() {
        try{
            System.out.println("UTF-16");
            String korean = "나종완";

            byte[] array1 = korean.getBytes("UTF-16");
            printByteArray(array1);

            String korean2 = new String(array1, "UTF-16");
            System.out.println(korean2);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
