package annotation;

public class Animal {
	private int footCount;
	private String name;
	
	public Animal(int footCount, String name) {
		this.footCount = footCount;
		this.name = name;
	}
	
	public void walking(String name) {
		System.out.print(name + " is walking");
	}
	
}
