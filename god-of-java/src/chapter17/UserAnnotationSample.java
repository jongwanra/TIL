package chapter17;

public class UserAnnotationSample {
    @UserAnnotation(number = 0)
    public static void main(String[] args) {
        UserAnnotationSample sample = new UserAnnotationSample();

    }

    @UserAnnotation(number = 1)
    public void annotationSample1() {

    }

    @UserAnnotation(number = 2, text= "second")
    public void annotationSample2() {

    }

    @UserAnnotation(number = 2, text= "third")
    public void annotationSample3() {

    }


}
