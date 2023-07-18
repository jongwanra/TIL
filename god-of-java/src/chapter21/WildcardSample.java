package chapter21;

public class WildcardSample {
    public static void main(String[] args) {
        WildcardSample sample = new WildcardSample();
        sample.callWildcardMethod();
    }

    private void callWildcardMethod() {
        WildcardGeneric<String> wildcard = new WildcardGeneric<String>();
//        wildcard.setWildcard("A");
        wildcardStringMethod(wildcard, "A");
    }

    // 여기서의 치명적인 단점?!
    // 매개 변수로 사용된 객체에 값을 추가할 수 없다.
    private <T> void wildcardStringMethod(WildcardGeneric<T> wildcard, T addValue) {
        wildcard.setWildcard(addValue);
        T value = wildcard.getWildcard();
        System.out.println("value = " + value);
        if (value instanceof String) {
            System.out.println(value);
        }else {
            System.out.println("Unknown value");
        }

    }
}
