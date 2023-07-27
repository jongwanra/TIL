package study.java_is_pass_by_what;

class Dog {
    private String name;

    public String getName() {
        return this.name;
    }

    public Dog(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main( String[] args ){
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println("c = " + c);
//        Dog aDog = new Dog("Max");
//        foo(aDog);
//
//        if (aDog.getName().equals("Max")) { //true
//            System.out.println( "Java passes by value." );
//
//        } else if (aDog.getName().equals("Fifi")) {
//            System.out.println( "Java passes by reference." );
//        }
    }

    public static void foo(Dog d) {
        d.getName().equals("Max"); // true

        d = new Dog("Fifi");
        d.getName().equals("Fifi"); // true
    }

}
