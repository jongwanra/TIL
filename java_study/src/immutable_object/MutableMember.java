package immutable_object;

import java.util.Objects;

class MutableMember {
	private String name;
	private int age;
	
	private MutableMember(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public static MutableMember withNameAndAge(String name, int age) {
		return new MutableMember(name, age);
	}
	
	public void changeName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MutableMember that = (MutableMember)o;
		return age == that.age && Objects.equals(name, that.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
}

