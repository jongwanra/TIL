package chapter10.inheritance;

public class InheritancePrint {
    public static void main(String[] args) {
        Child child = new Child();
        /*
        * 출력을 하고 나면 결과가
        * Parent Constructor
        * Child Constructor
        * Parent PrintName()
        * 순으로 출력된다.
        * 생성시에 부모부터 생성이 되네.?!!
        *
        * */
//        child.printName();
        System.out.println("---------");

//        ChildArg childArg = new ChildArg();
//        childArg.printName();
    }
}
