package chapter24;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapSample {
    public static void main(String[] args) {
        TreeMapSample sample = new TreeMapSample();
        sample.checkTreeMap();
    }

    private void checkTreeMap() {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("A", "a");
        map.put("가", "a");
        map.put("나", "a");
        map.put("1", "a");
        map.put("2", "a");
        map.put("a", "a");


        Set<Map.Entry<String, String>> entries = map.entrySet();
        for(Map.Entry<String, String> tempEntry: entries) {
            System.out.print("tempEntry.getKey() = " + tempEntry.getKey() + " ");
            System.out.println("tempEntry.getValue() = " + tempEntry.getValue());
        }

    }
}
