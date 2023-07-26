package chapter24;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSample {
    public static void main(String[] args) {
        MapSample sample = new MapSample();
//        sample.checkHashMap();
//        sample.checkKeySet();
        sample.checkHashCode();
    }

    private void checkHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");

        System.out.println("map.get(\"A\") = " + map.get("A"));
//        System.out.println("map.get(\"B\") = " + map.get("B"));
        map.put("A", "AA");
        map.put("B", "BB");

    }

    private void checkKeySet() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");
        map.put("C", "c");
        map.put("D", "d");
        Set<String> keySet = map.keySet();

        for(String x: keySet) {
            System.out.println("x = " + x);
        }


        Collection<String> values = map.values();
        for(String x: values) {
            System.out.println("x = " + x);
        }

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for(Map.Entry<String, String> x: entries){
            System.out.println("key: " + x.getKey() + " value: " + x.getValue());
        }
    }


    private void checkHashCode() {
        String sentence = "Hello Jongwan I want to know hashCode logic";
        System.out.println("sentence.hashCode() = " + sentence.hashCode());
        byte[] sentenceBytes = sentence.getBytes();
        for(byte x: sentenceBytes) {
            System.out.print(x + " ");
        }
        System.out.println();

        int h = 0;
        int length = sentence.length() >> 1;
        for(byte x: sentenceBytes) {
            h = 31 * h + (x ^ 0xff);
//            System.out.println("h = " + h);
        }
        System.out.println("h = " + h);

        System.out.println(h == sentence.hashCode());

    }
}
