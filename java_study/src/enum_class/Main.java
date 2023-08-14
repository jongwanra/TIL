package enum_class;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		System.out.println("apple = " + Fruit.APPLE.name());
		CFruitObj orange1 = CFruit.ORANGE;
		CFruitObj orange2 = CFruit.ORANGE;
		System.out.println(orange1 == orange2);
		
		main.checkPassWithEnum(Fruit.APPLE);
		main.checkPassWithEnum(null);
	}
	
	private void checkPassWithEnum(Fruit fruit) {
		System.out.println("fruit = " + fruit);
	}
	
}
