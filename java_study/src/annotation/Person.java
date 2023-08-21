package annotation;

public class Person extends Animal {
	private int age;
	
	public Person(int age, String name) {
		super(2, name);
		this.age = age;
	}
	
	@Override
	public void walking(String name) {
		super.walking(name);
	}
}
