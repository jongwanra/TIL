package chapter8;

public class ReferencePass {
    public static void main(String[] args) {
        ReferencePass referencePass = new ReferencePass();
//        referencePass.callPassByValue();
        
        referencePass.callPassByReference();

    }


    // Sangmin
    // SungChoon
    private void callPassByReference() {
        MemberDto member = new MemberDto("Sangmin");
        System.out.println("before");
        System.out.println("member.name = " + member.name);
        passByReference(member);
        System.out.println("member.name = " + member.name);
    }

    private void passByReference(MemberDto member) {
        member.name = "SungChoon";
        System.out.println("in passByReference");
        System.out.println("member.name = " + member.name);
    }

    public void callPassByValue() {
        int a= 10;
        String b= "b";
        System.out.println("before passByValue");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        passByValue(a, b);
        System.out.println("after passByValue");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    private void passByValue(int a, String b) {
        a = 20;
        b = "z"; // new String("z") 와 동일하기 떄문에 값이 변경되지 않는다.
        System.out.println("in passByValue");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }


}
