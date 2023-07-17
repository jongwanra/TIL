package chapter9;

import chapter9.sub.ProtectedAccessModifier;

public class AccessCall {
    public static void main(String[] args) {
        AccessModifier accessModifier = new AccessModifier();
        ProtectedAccessModifier protectedAccessModifier = new ProtectedAccessModifier();
        accessModifier.publicMethod();
        accessModifier.packagePrivateMethod();
        // 'protectedMethod()' has protected access in 'chapter9.sub.ProtectedAccessModifier'
        //  protectedAccessModifier.protectedMethod();
        //'privateMethod()' has private access in 'chapter9.AccessModifier'
        // accessModifier.privateMethod();

    }
}
