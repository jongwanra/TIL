package hash_map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		LinkedHashMapTest main = new LinkedHashMapTest();
		
		// main.checkLinkedHashMap();
		// main.testLRUCache();
		
		main.testAccessOrder();
	}
	
	private void testAccessOrder() {
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>(10, 0.75f, true);
		for (int i = 1; i <= 10; i++) {
			lhm.put(i, "a");
		}
		
		lhm.get(5);
		lhm.get(5);
		lhm.get(5);
		lhm.get(6);
		lhm.get(6);
		lhm.get(7);
		
		for (Integer x : lhm.keySet()) {
			System.out.println("x = " + x);
		}
	}
	
	private void testLRUCache() {
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>() {
			@Override
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return this.size() >= 10_000;
			}
		};
		
		for (int i = 1; i <= 100_000; i++) {
			lhm.put(i, "a");
		}
		
		System.out.println(lhm.size());
		;
	}
	
	private void checkLinkedHashMap() {
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
		
		for (int i = 1; i <= 100_000; i++) {
			lhm.put(i, "a");
		}
		
		// for (Map.Entry<Integer, String> entry : lhm.entrySet()) {
		// 	System.out.println("entry = " + entry.getKey());
		// }
		
		for (Integer s : lhm.keySet()) {
			System.out.println(s);
		}
		
	}
	
}
