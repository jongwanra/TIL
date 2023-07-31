import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple","Banana","Melon","Grape","Strawberry"));

        System.out.println(list.stream().toString());

        String a = "asdasdas";
        boolean what = a.equals("asdasdas");
        System.out.println("what = " + what);
        int what2 = a.hashCode();
        System.out.println("what2 = " + what2);
        int what3 = a.hashCode();
        System.out.println("what3 = " + what3);
    }
}
