package study.annotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {

        Hashtable<Object, Object> map = new Hashtable<>();
        HashMap<Object, Object> hashMap = new HashMap<>();

        ArrayList list = new ArrayList<>(); // 제네릭 타입을 지정하지 않음!

        list.add("1"); // 경고 발생 !!! 경고 내용 = unchecked

    }
}
