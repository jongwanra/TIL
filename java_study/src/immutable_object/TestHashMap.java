package immutable_object;

import java.util.HashMap;

public class TestHashMap {
	
	public static void main(String[] args) {
		TestHashMap test = new TestHashMap();
		test.checkHashMapByMutableMember();
		System.out.println("-------");
		test.checkHashMapByImmutableMember();
	}
	
	private void checkHashMapByMutableMember() {
		HashMap<MutableMember, Boolean> map = new HashMap<>();
		MutableMember memberA = MutableMember.withNameAndAge("memberA", 20);
		map.put(memberA, true);
		
		// before change Name: map.get(memberA) = true
		System.out.println("before change Name: map.get(memberA) = " + map.get(memberA));
		
		memberA.changeName("memberAA");
		
		// after change name: map.get(memberA) = null
		System.out.println("after change name: map.get(memberA) = " + map.get(memberA));
		
	}
	
	private void checkHashMapByImmutableMember() {
		HashMap<ImmutableMember, Boolean> map = new HashMap<>();
		ImmutableMember memberA = ImmutableMember.withNameAndAge("memberA", 20);
		map.put(memberA, true);
		
		// before change Name: map.get(memberA) = true
		System.out.println("before change Name: map.get(memberA) = " + map.get(memberA));
		
		ImmutableMember memberAA = memberA.changeName("memberAA");
		
		// after change name: map.get(memberA) = true
		System.out.println("after change name: map.get(memberA) = " + map.get(memberA));
		
	}
}
