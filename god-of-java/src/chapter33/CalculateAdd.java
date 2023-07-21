package chapter33;

public class CalculateAdd {

    private void calculateClassic( ) {
        Calculate calculateAdd = new Calculate() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };
    }

    private void calculateLambda() {
        Calculate calculateAdd = (a, b) -> a + b;
        System.out.println("calculateAdd = " + calculateAdd);
    }

}
