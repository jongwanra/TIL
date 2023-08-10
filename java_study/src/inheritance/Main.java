package inheritance;

class Parent {
	private int privateField;
	
	public Parent(int value) {
		privateField = value;
	}
	
	public int getPrivateField() {
		return privateField;
	}
	
	private void privateMethod() {
		System.out.println("Private method in Parent");
	}
	
	public void publicMethod() {
		System.out.println("Public method in Parent");
	}
}

class Child extends Parent {
	public Child(int value) {
		super(value);
	}
	
	// 자식 클래스에서 부모의 private 필드에 접근하기 위한 메소드
	// 부모 클래스의 private 메소드에 접근하기 위한 메소드
	
	@Override
	public int getPrivateField() {
		return super.getPrivateField();
	}
	
	// 오버라이딩된 public 메소드
	@Override
	public void publicMethod() {
		System.out.println("Public method in Child");
		// privateMethod(); // 컴파일 에러 발생
	}
}

public class Main {
	public static void main(String[] args) {
		Child child = new Child(42);
		child.publicMethod();
		System.out.println(child.getPrivateField());
	}
}

