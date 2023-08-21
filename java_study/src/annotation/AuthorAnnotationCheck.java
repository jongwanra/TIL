package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AuthorAnnotationCheck {
	public static void main(String[] args) {
		AuthorAnnotationCheck sample = new AuthorAnnotationCheck();
		sample.checkAnnotations(AuthorAnnotationTest.class);
	}
	
	private void checkAnnotations(Class<AuthorAnnotationTest> targetClass) {
		Method[] methods = targetClass.getDeclaredMethods();
		for (Method tempMethod : methods) {
			Annotation annotation = tempMethod.getAnnotation(Author.class);
			if (annotation instanceof Author) {
				String name = ((Author)annotation).name();
				System.out.println("name = " + name);
			}
		}
	}
}
