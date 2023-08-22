package nested_class;

public class InnerSample {
	public static void main(String[] args) {
		InnerSample sample = new InnerSample();
		
		sample.makeInnerObject();
	}
	
	private void makeInnerObject() {
		OutOfInner outOfInner = new OutOfInner();
		OutOfInner.Inner inner = outOfInner.new Inner();
		inner.setValue(3);
		
		System.out.println(inner.getValue());
	}
}
