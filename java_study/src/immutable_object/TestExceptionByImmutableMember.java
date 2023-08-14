package immutable_object;

public class TestExceptionByImmutableMember {
	public static void main(String[] args) {
		TestExceptionByImmutableMember test = new TestExceptionByImmutableMember();
		
		test.checkException();
	}
	
	private void checkException() {
		ImmutableMember memberA = ImmutableMember.withNameAndAge("memberA", 20);
		// before memberA.getName() = memberA
		System.out.println("before memberA.getName() = " + memberA.getName());
		try {
			occurException(memberA);
		} catch (RuntimeException e) {
			// after memberA.getName() = memberA
			System.out.println("after memberA.getName() = " + memberA.getName());
		}
		
	}
	
	private void occurException(ImmutableMember member) throws RuntimeException {
		
		member.changeName("memberAA");
		throw new RuntimeException("Occured Error!");
	}
}
