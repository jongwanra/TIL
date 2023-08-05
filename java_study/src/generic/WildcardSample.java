package generic;

public class WildcardSample {
    public static void main(String[] args) {
        WildcardSample sample = new WildcardSample();
        sample.callWildcardMethod();

    }

    private void callWildcardMethod() {
//        WildcardGeneric<?> wildcard = new WildcardGeneric<String>();
//        System.out.println("조회 시에는 문제 안발생?!: " + wildcard.getWildcard());

//        wildcardStringMethod(wildcard, "A");
//
//        System.out.println("wildcard.getWildcard() = " + wildcard.getWildcard());
    }

//    private <T> void wildcardStringMethod(WildcardGeneric<T> c, T addValue) {
//        c.setWildcard(addValue);
//    }
}
