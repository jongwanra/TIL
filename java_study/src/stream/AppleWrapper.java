package stream;

enum Color {
	RED, GREEN, YELLOW
}

class Apple {
	private int id;
	private Color color;
	
	public Apple(int id, Color color) {
		this.id = id;
		this.color = color;
	}
	
	public int getId() {
		return id;
	}
	
	public Color getColor() {
		return color;
	}
}

public class AppleWrapper {
	private Apple apple;
	
	private AppleWrapper(Apple apple) {
		this.apple = apple;
	}
	
	public static AppleWrapper of(Apple apple) {
		return new AppleWrapper(apple);
	}
	
	public Apple ripOpen() {
		return apple;
	}
}

class Dto {
	private int id;
	private Color color;
	
	public Dto(Apple apple) {
		this.id = apple.getId();
		this.color = apple.getColor();
	}
	
	@Override
	public String toString() {
		return "Dto{" +
			"id=" + id +
			", color=" + color +
			'}';
	}
}