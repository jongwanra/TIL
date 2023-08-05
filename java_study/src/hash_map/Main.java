package hash_map;

import java.util.HashMap;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>(16);

        System.out.println("hashMap = " + hashMap.size());
        for(int i = 0; i < 13; i++) {
            hashMap.put(i, "A");
        }

        hashMap.remove(1);
        System.out.println("HashMAp: " + hashMap);
        System.out.println("HashMAp: " + hashMap.keySet());

    }
}

