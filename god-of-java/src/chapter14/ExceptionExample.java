package chapter14;

public class ExceptionExample {
    public static void main(String[] args) {
        ExceptionExample exceptionExample = new ExceptionExample();
        exceptionExample.arrayOutOfBoundsTryCatch();
    }


    private void arrayOutOfBounds() {
        int[] intArray = new int[5];
        System.out.println("intArray[5] = " + intArray[5]);
    }

    private void arrayOutOfBoundsTryCatch() {

            int[] intArray = new int[5];
        try{
            System.out.println("intArray[5] = " + intArray[5]);
            System.out.println("This code should run"); // x
        }catch (Exception e) {
            System.out.println("e = " + e);
            System.out.println("Exception Occured"); // o
        }
        System.out.println("Thi Code must run"); // o

    }
}
