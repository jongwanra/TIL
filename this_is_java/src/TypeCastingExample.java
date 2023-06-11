public class TypeCastingExample {

    /*
    * 자동 타입 변환
    * 값의 허용 범위가 작은 타입이 허용 범위가 큰 타입으로 대입될 때 발생
    * 기본 타입을 허용 범위 순으로 나열하면 아래와 같다.
    * byte(1) < short(2), char(2) < int(4) < long(8) < float(4) < double(8)
    * boolean(1)
    */
    public static void main(String[] args) {
         byte byteValue = 10;
         int intValue = byteValue; // 자동 타입 변환됨


        long longValue = 500000000L;
        float floatValue = longValue;

        System.out.println("floatValue = " + floatValue);
        double doubleValue = longValue;

        System.out.println("doubleValue = " + doubleValue);


        char charValue = 'A';
        int intValue2 = charValue;

        System.out.println("intValue2 = " + intValue2);


//        byte byteValue2 = 65;
//        char charValue2 = byteValue2;
//
//        System.out.println("charValue2 = " + charValue2);



        /*
        *
        * 강제 타입 변환
        */


        int intValue3 = 10;
        byte byteValue3 = (byte) intValue3;

        System.out.println("byteValue3 = " + byteValue3);


        int intValue4 = 130;
        byte byteValue4 = (byte) intValue4;

        System.out.println("byteValue4 = " + byteValue4);

    }
}