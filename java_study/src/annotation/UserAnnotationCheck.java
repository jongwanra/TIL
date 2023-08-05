package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class UserAnnotationCheck {
    public static void main(String[] args) {
        UserAnnotationCheck sample = new UserAnnotationCheck();
        sample.checkAnnotations(UserAnnotationSample.class);
    }

    private void checkAnnotations(Class<UserAnnotationSample> useClass) {
        Method[] methods = useClass.getDeclaredMethods();
        for (Method tempMethod: methods) {
            Annotation annotation = tempMethod.getAnnotation(UserAnnotation.class);
            System.out.println("annotation = " + annotation);
//            if(annotation != null) {
//                int number = annotation.number();
//                String test = annotation.text();
//                System.out.println(tempMethod.getName() + "() : number=" + number + " text=" + test);
//            }else {
//                System.out.println(tempMethod.getName() + "() : annotation is null.");
//            }
        }
    }
}
