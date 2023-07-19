package chapter24;

import java.util.HashMap;

public class MapSample {
    public static void main(String[] args) {
        MapSample sample = new MapSample();
        sample.checkHashMap();
    }

    private void checkHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");

        System.out.println("map.get(\"A\") = " + map.get("A"));
//        System.out.println("map.get(\"B\") = " + map.get("B"));
        map.put("A", "AA");
        map.put("B", "BB");

        System.out.println("map.get(\"A\") = " + map.get("A"));
        System.out.println("map = " + map);
    }
}
