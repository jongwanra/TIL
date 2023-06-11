public class StringType {
    public static void main(String[] args) {
        /*
         * 문자열 비교
         * 자바는 문자열 리터럴이 동일하다면 String 객체를 공유하도록 설계되어져 있다.
         * 다음과 같이 name1과 name2 변수에 "홍길동"을 대입할 겨우, 동일한 String 객체의 번지가 저장 된다.
         */

        String name1 = "hong";
        String name2 = "hong";

        // true
        System.out.println("name1 == name2::" + (name1 == name2));

        // false
        String name3 = new String("hong");
        String name4 = new String("hong");

        System.out.println("name3 == name4 :: " + (name3 == name4));


        /*
        * 동일한 Stringf 객체든 다른 String 객체든 상관없이
        * 내부 문자열만을 비교할 경우에는 String 객체의 equals() 메소드를 사용한다.
        * */

        // true
        boolean result = name1.equals(name2);

        System.out.println("result = " + result);


        // 문자열 비교 시 equals를 사용하자

        // StringIndexOutOfBoundsException
        // System.out.println("charAt(3)::"  + name2.charAt(4));




        /*
        * 자바에서 만들어지는 문자열은 무조건 불변이다. 한 번 만들어진 문자열은
        * 변하지 않는다 -> 변하지 않고 새로 생성 되어서 만들어진다.
        * */


        String oldStr = "자바 프로그래밍";
        String newStr = oldStr.replace("자바", "JAVA");

        System.out.println("oldStr = " + oldStr);
        System.out.println("newStr = " + newStr);



        // 문자열 잘라내기
        String ssn = "950101-1112345";
        String firstNum = ssn.substring(0, 6);
        String secondNum = ssn.substring(7);

        System.out.println("ssn = " + ssn);
        System.out.println("firstNum = " + firstNum);
        System.out.println("secondNum = " + secondNum);
        
        
        // 문자열 찾기
        String subject = "자바 프로그래밍";
        

        // 3
        int findIndex = subject.indexOf("프로그래밍");
        // -1
        int notFindIndex = subject.indexOf("프래");

        System.out.println("findIndex = " + findIndex);
        System.out.println("notFindIndex = " + notFindIndex);


        boolean isContain = subject.contains("프로그래밍");
        System.out.println("isContain = " + isContain);


        // 문자열 분리
        String board = "번호,제목,내용,글쓴이";
        String[] splitedBoard = board.split(",");

        for(String s:splitedBoard){
            System.out.println("s = " + s);
        }
        
    }
}
