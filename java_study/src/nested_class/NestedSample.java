package nested_class;

public class NestedSample {
	public static void main(String[] args) {
		NestedSample sample = new NestedSample();
		sample.makeStaticNestedObject();
	}
	
	private void makeStaticNestedObject() {
		OutOfStatic.StaticNested staticNested = new OutOfStatic.StaticNested();
		staticNested.setValue(3);
		System.out.println(staticNested.getValue());
		
		OutOfStatic outOfStatic = new OutOfStatic();
		
	}
}
