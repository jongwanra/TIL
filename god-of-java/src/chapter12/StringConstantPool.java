package chapter12;

public class StringConstantPool {
    public static void main(String[] args) {
        String literalAppleOne = "Apple";
        String literalAppleTwo = "Apple";
        String newAppleOne = new String("Apple");
        String newAppleTwo = new String("Apple");

        // literalAppleOne == literalAppleTwo: true
        System.out.println("literalAppleOne == literalAppleTwo: " + (literalAppleOne == literalAppleTwo));

        // literalAppleOne == newAppleOne: false
        System.out.println("literalAppleOne == newAppleOne: " + (literalAppleOne == newAppleOne));

        // newAppleOne == newAppleTwo: false
        System.out.println("newAppleOne == newAppleTwo: " + (newAppleOne == newAppleTwo));

    }
}
