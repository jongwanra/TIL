package hash_map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap<>();
		
		map.put("A", true);
		
		// get() method의 특징은 원자성은 보장되지 않지만, 가시성이 보장되어져 있다
		map.get("A");
	}
}
