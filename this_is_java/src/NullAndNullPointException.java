public class NullAndNullPointException {
    public static void main(String[] args) {
        try{
            int[] intArray = null;
            intArray[0] = 10; // NullPointException
        }catch (NullPointerException e){
            System.out.println(e);

        }
    }
}
