package chapter16;

public class NestedSample {
    public static void main(String[] args) {
        NestedSample sample = new NestedSample();
        sample.makeStaticNestedObject();
    }

    private void makeStaticNestedObject() {
        OuterOfStatic.StaticNested staticNested = new OuterOfStatic.StaticNested();
        staticNested.setValue(3);

        System.out.println("staticNested.getValue() = " + staticNested.getValue());
    }
}
