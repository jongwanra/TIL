package annotation;

public class AuthorAnnotationTest {
	
	public static void main(String[] args) {
		AuthorAnnotationTest sample = new AuthorAnnotationTest();
	}
	
	@Author(name = "D")
	public void annotationSample1() {
	}
	
	@Author(name = "C")
	public void annotationSample2() {
	
	}
	
	@Author(name = "B")
	public void annotationSample3() {
	
	}
}
