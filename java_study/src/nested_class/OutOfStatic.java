package nested_class;

public class OutOfStatic {
	
	static class StaticNested {
		private int value = 0;
		
		public int getValue() {
			return value;
		}
		
		public void setValue(int value) {
			this.value = value;
		}
	}
	
}
