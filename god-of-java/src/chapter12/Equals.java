package chapter12;


public class Equals {
    public static void main(String[] args) {
        Equals thisObject = new Equals();
        thisObject.equalMethodByString();
    }


    private void equalMethodByString() {
        String a = "10000"; // new String("10000");
        String b = new String("10000");
        System.out.println("a.hashCode() = " + a.hashCode());
        System.out.println("b.hashCode() = " + b.hashCode());
        if (a == b) {
            System.out.println("a, b string is same");
        }else {
            System.out.println("a, b string is different");
        }
    }
    private void equalMethod() {
        MemberDto obj1 = new MemberDto("Sangmin");
        MemberDto obj2 = new MemberDto("Sangmin");

        if (obj1 == obj2) {
            System.out.println(" obj1 and obj2 is same");
        }else {
            System.out.println("obj1 and obj2 is different");
        }
    }

    private void equalMethod2() {
        MemberDto obj1 = new MemberDto("Sangmin");
        MemberDto obj2 = new MemberDto("Sangmin");

        if (obj1.equals(obj2)) {
            System.out.println(" obj1 and obj2 is same");
        }else {
            System.out.println("obj1 and obj2 is different");
        }
    }
}
