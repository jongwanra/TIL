package study.java_is_pass_by_what;

class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public Person(int age) {
        this.age = age;
    }
}
public class Main {
    private static void updateReferenceType(Person person) {
        person = new Person(20);
    }
    public static void main(String[] args) {

        Person referenceTypePerson = new Person(29);
        // output: before update reference type: 29
        System.out.println("before update reference type: " + referenceTypePerson.getAge());

        updateReferenceType(referenceTypePerson);
        // output: after update reference type: 29
        System.out.println("after update reference type: " + referenceTypePerson.getAge());
    }
}




