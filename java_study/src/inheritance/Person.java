package inheritance;

class Animal {

    private int footCount;

    public Animal(int footCount) {
        this.footCount = footCount;
    }

    protected void eat() {
        System.out.println("eat!");
    }

    protected void sleep () {
        System.out.println("sleep!");
    }

    protected int getFootCount() {
        return footCount;
    }
}

public class Person extends Animal {
    private static final int FOOT_COUNT = 2;
    private String name;
    private int age;

    public Person(String name, int age) {
        super(FOOT_COUNT);
        this.name = name;
        this.age = age;

    }

    @Override
    protected void eat() {
        System.out.println(name + " is eating");
    }

    @Override
    protected void sleep() {
        System.out.println(name + " is sleeping");
    }

    public static void main(String[] args) {
        Person jongwan = new Person("jongwan", 29);
        jongwan.eat();
        jongwan.sleep();
        System.out.println(jongwan.getFootCount());;

    }
}
