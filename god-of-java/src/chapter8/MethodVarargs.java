package chapter8;

public class MethodVarargs {

    public static void main(String[] args) {
        MethodVarargs varargs = new MethodVarargs();
        varargs.calculateNumbersWithArray(new int[]{1, 2,3,4,5});
        varargs.calculateNumbers(1,2,3,4,5);
    }

    private void calculateNumbers(int...numbers) {
        for(int number: numbers) {
            System.out.println("number:" + number);
        }
    }

    private void calculateNumbersWithArray(int[] numbers) {
    }
}
