package hash_map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.checkHashTable();
    }

    private void checkHashMap() {
        HashMap<Integer, String> hashMap = new HashMap<>(16);

        System.out.println("hashMap = " + hashMap.size());
        for(int i = 0; i < 13; i++) {
            hashMap.put(i, "A");
        }

        hashMap.remove(1);
        System.out.println("HashMAp: " + hashMap);
        System.out.println("HashMAp: " + hashMap.keySet());
    }

    private void checkConcurrentHashMap() {
        ConcurrentHashMap<Integer, Integer> chm = new ConcurrentHashMap<>();
        chm.put(1, 1);
    }

    private void checkHashTable() {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        ht.put(null, 1);
    }
}

