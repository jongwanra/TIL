public class CalculateExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.sum(1,2,3,4,5,6,7);
        calculator.sum(new int[]{1, 2, 3, 4, 5});
        System.out.println(calculator.getTotal());

    }
}
