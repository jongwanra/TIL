package immutable_object;

import java.util.Objects;

public final class ImmutableMember {
	private final String name;
	private final int age;
	
	private ImmutableMember(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public static ImmutableMember withNameAndAge(String name, int age) {
		return new ImmutableMember(name, age);
	}
	
	public String getName() {
		return name;
	}
	
	public ImmutableMember changeName(String name) {
		return new ImmutableMember(name, this.age);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ImmutableMember that = (ImmutableMember)o;
		return age == that.age && Objects.equals(name, that.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
}

