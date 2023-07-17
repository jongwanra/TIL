package chapter14;

public class FinallySample {
    public static void main(String[] args) {
        FinallySample sample = new FinallySample();
        sample.finallySample();
    }

    private void finallySample() {
        int[] intArray = new int[5];

        try{
            System.out.println(intArray[5]);

        }catch (Exception e){
            System.out.println(intArray.length);
            return;
        }finally {
            System.out.println("Here is Finally");

        }
        System.out.println("Thi Code must run"); // o
    }
}
