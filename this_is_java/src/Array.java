public class Array {
    public static void main(String[] args) {
        System.out.println("=======");
        printArrays(args);
        System.out.println("=======");
        /* 배열 타입 */


        /*
         * 특징
         * 1. 배열은 전부 같은 타입이다.
         * 2. 한 번 생성된 배열의 크기(길이)는 변경이 불가능하다.
         * */




        /* 배열 변수 선언 */
        String[] strArray = {"A", "B", "C"};

        printArrays(strArray);
        System.out.println("========");
        strArray[0] = "D";
        printArrays(strArray);



        /*
         * Array 변수를 재 선언 하려고 했을 때 new 연산자가 아닌 재할당을 했을 때는 컴파일 에러를 뱉는다
         * 재선언 해주기 위해서는 new 연산자로 선언이 필요
         *
         * */

        String[] names = null;

        // X -> names = {"홍길동", "김다미"};
        names = new String[]{"홍길동", "김다미"};



        /*
         *  new 연산자로 배열 생성
         * - 배열 항목을 기본값으로 초기화한 배열 생성
         *
         */

        int[] intArray = new int[5];
        printArrays(intArray);


        boolean[] booleanArray = new boolean[5];
        printArrays(booleanArray);

    }


    private static void printArrays(Object[] objects) {
        for (Object object : objects) {
            System.out.println("object = " + object);
        }
    }

    private static void printArrays(int[] intArray) {
        for (int v : intArray) {
            System.out.println("v = " + v);
        }
    }

    private static void printArrays(boolean[] booleanArray) {
        for (boolean v : booleanArray) {
            System.out.println("v = " + v);
        }
    }
}
