package enum_class;

public class Main {
    public static void main(String[] args) {
        System.out.println("apple = " + Fruit.APPLE.name());
        CFruitObj orange1 = CFruit.ORANGE;
        CFruitObj orange2 = CFruit.ORANGE;
        System.out.println(orange1 == orange2);


    }
}
