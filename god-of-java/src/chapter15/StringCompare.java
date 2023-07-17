package chapter15;

public class StringCompare {
    public static void main(String[] args) {
        StringCompare sample = new StringCompare();
//        sample.checkString();
//        sample.checkCompare();
//        sample.checkCompareTo();
        sample.checkIndexOf();
    }

    private void checkCompare() {
        String text = "Check Value";
        String text2 = "Check Value";

        if ( text == text2) {
            System.out.println("is same.");
        }else {
            System.out.println("is different");
        }

        // equalsIgnoreCase()
        String text3 = "check value";
        if(text.equalsIgnoreCase(text3)) {
            System.out.println("equalsIgnoreCase is same");
        }

    }
    private void checkString() {
        // length
        String text = "You must know String class";
        System.out.println("text = " + text);
        System.out.println("text.length() = " + text.length());

        String koreanText = "나는 문자열 클래스를 보고 있다.";
        System.out.println("koreanText = " + koreanText);
        System.out.println("koreanText.length() = " + koreanText.length());

        // isEmpty
        String emptyText = "";
        String nullText = null;

        System.out.println("emptyText = " + emptyText.isEmpty());
        // null에 isEmpty를 접근할 경우 -> NullPointException 발생
        // System.out.println("nullText.isEmpty() = " + nullText.isEmpty());

        System.out.println("text = " + text.isEmpty());
        System.out.println("koreanText.isEmpty() = " + koreanText.isEmpty());
    }

    private void checkCompareTo() {
        String text = "a";
        String text2 = "b";
        String text3 = "c";

        System.out.println(text2.compareTo(text));
        System.out.println(text2.compareTo(text3));
        System.out.println(text.compareTo(text3));
    }

    private void  checkIndexOf() {
        String addressA = "서울특별시 구로구 103";
        String target = "서울특별시";

        if (addressA.indexOf(target) > -1) {
            System.out.println("addressA.indexOf(target) is Success");
        }

        if( addressA.startsWith(target)) {
            System.out.println("addressA.startsWith(target) is Success");
        }
    }
}
