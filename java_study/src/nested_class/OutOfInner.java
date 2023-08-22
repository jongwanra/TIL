package nested_class;

public class OutOfInner {
	class Inner {
		private int value = 0;
		
		public int getValue() {
			return value;
		}
		
		public void setValue(int value) {
			this.value = value;
		}
	}
}