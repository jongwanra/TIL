package immutable_object;

public class TestExceptionByMutableMember {
	public static void main(String[] args) {
		TestExceptionByMutableMember test = new TestExceptionByMutableMember();
		
		test.checkException();
	}
	
	private void checkException() {
		MutableMember memberA = MutableMember.withNameAndAge("memberA", 20);
		// before memberA.getName() = memberA
		System.out.println("before memberA.getName() = " + memberA.getName());
		try {
			occurException(memberA);
		} catch (RuntimeException e) {
			// after memberA.getName() = memberAA
			System.out.println("after memberA.getName() = " + memberA.getName());
		}
		
	}
	
	private void occurException(MutableMember member) throws RuntimeException {
		
		member.changeName("memberAA");
		throw new RuntimeException("Occured Error!");
	}
}
