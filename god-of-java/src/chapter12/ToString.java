package chapter12;

public class ToString {
    public static void main(String[] args) {
        ToString thisObject = new ToString();
        thisObject.toStringMethod(thisObject);
    }

    private void toStringMethod(Object obj) {
        System.out.println(obj);
        System.out.println(obj.toString());
        System.out.println("plus " + obj);
    }

    @Override
    public String toString() {
        return "ToString class";
    }
}
