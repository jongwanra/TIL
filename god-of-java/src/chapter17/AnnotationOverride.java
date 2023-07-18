package chapter17;

public class AnnotationOverride extends Parent {
    @Override
    public void printName() {
        System.out.println("AnnotationOverride");
    }
}
