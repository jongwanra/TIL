package chapter17;

import java.lang.reflect.Method;

public class UserAnnotationCheck {

    public static void main(String[] args) {
        UserAnnotationCheck sample = new UserAnnotationCheck();
        sample.checkAnnotations(UserAnnotationSample.class);
    }

    private void checkAnnotations(Class useClass) {
        // 해당 클래스에 선언되어 있는 메소드들의 목록을 배열로 리턴
        Method[] methods = useClass.getDeclaredMethods();
        for(Method tempMethod: methods) {
            UserAnnotation annotation = tempMethod.getAnnotation(UserAnnotation.class);
            if (annotation != null) {
                int number = annotation.number();
                String text = annotation.text();
                System.out.println(tempMethod.getName() + "(): number=" + number + " text=" + text);
            } else {
                System.out.println(tempMethod.getName() + "(): annotation is null");
            }

        }
    }
}
