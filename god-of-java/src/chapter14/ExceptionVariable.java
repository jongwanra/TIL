package chapter14;

public class ExceptionVariable {
    public static void main(String[] args) {
        ExceptionVariable exceptionVariable = new ExceptionVariable();
        exceptionVariable.checkVariable();
    }

    private void checkVariable() {
        int[] intArray = new int[5];

        try{
            System.out.println(intArray[5]);
        }catch (Exception e){
            System.out.println(intArray.length);
        }

        System.out.println("Thi Code must run"); // o
    }
}
