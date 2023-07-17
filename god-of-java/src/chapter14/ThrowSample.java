package chapter14;

public class ThrowSample {

    public static void main(String[] args){
        try{
            ThrowSample sample = new ThrowSample();
            sample.throwException(13);
        }catch (Exception e){

        }

    }

    private void throwException(int number) throws Exception {
        if(number > 12) {
            throw new Exception("Number is over than 12");
        }
    }
}
