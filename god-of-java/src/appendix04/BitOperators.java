package appendix04;

public class BitOperators {
    public static void main(String[] args) {
        System.out.println("Math.max(1, 2) = " + Math.max(1, 2));
        BitOperators sample = new BitOperators();
        int a = 1, b = 7;
//        sample.andOperation(a, b);
//        sample.orOperation(a, b);
//        sample.xorOperation(a, b);
//        a = 1;
//        b = 3;
//
//        sample.andOperation(a, b);
//        sample.orOperation(a, b);
//        sample.xorOperation(a, b);
        a = -10;
        b = 10;
        sample.andOperation(a, b);
        sample.orOperation(a, b);
        sample.xorOperation(a, b);

//        sample.andOrXorSample();
    }

    private void xorOperation(int a, int b) {
        int result = a ^ b;
        this.printValue(" a", a);
        this.printValue(" b", b);
        this.printValue(" a ^ b", result);
        System.out.println();
    }

    private void orOperation(int a, int b) {
        int result = a | b;
        this.printValue(" a", a);
        this.printValue(" b", b);
        this.printValue(" a | b", result);
        System.out.println();

    }

    private void andOperation(int a, int b) {
        int result = a & b;
        this.printValue(" a", a);
        this.printValue(" b", b);
        this.printValue(" a & b", result);
        System.out.println();
    }

    private void printValue(String variableName, int a) {
        System.out.print(variableName + "=");
        int aZeroCount = Integer.numberOfLeadingZeros(a);
        for (int loop = 0; loop < aZeroCount; loop++) {
            System.out.print("0");
        }

        if (Integer.SIZE == aZeroCount) {
            System.out.println("\t[" + a + "]");
        } else {
            System.out.println(Integer.toBinaryString(a) + "\t[" + a + "]");
        }
    }

    private void andOrXorSample() {
    }
}
