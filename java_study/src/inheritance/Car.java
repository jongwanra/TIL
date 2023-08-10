package inheritance;

class Engine {
	public void start() {
		System.out.println("Start!!");
	}
}

class Vehicle {
	
	private Engine engine;
	
	public Vehicle() {
		this.engine = new Engine();
	}
	
	public void startEngine() {
		engine.start();
	}
	
}

public class Car extends Vehicle {
	
	@Override
	public void startEngine() {
		super.startEngine();
	}
}
